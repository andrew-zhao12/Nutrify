import sqlalchemy as db

'''
function that will be called when a user creates a new account
updates every table in database with new user info with columns set to 0
by default will return 1 if username or password is invalid (too long or
short)
will return 2 if username already exists
otherwise will return 0 after successful register
'''


def register(username, password):
    if len(username) == 0 or len(password) == 0 or len(username) > 63 \
            or len(password) > 63:
        return 1

    engine = db.create_engine('mysql://root:Group94@localhost:3306/nutrify')
    connection = engine.connect()
    metadata = db.MetaData()
    user_info = db.Table('User Info', metadata, autoload=True,
                         autoload_with=engine)
    retrieve_users = db.select([db.func.count(user_info.columns.Username)])\
        .where(user_info.columns.Username == username)
    retrieve_users = connection.execute(retrieve_users).fetchall()
    if retrieve_users[0][0] != 0:
        return 2

    nutritional_info = db.Table('Running Total on Daily Nutrition', metadata,
                                autoload=True, autoload_with=engine)
    user_preferences = db.Table('User Preferences', metadata, autoload=True,
                                autoload_with=engine)
    insert_userinfo = db.insert(user_info).values(Username=username,
                                                  Password=password)
    insert_nutrinfo = db.insert(nutritional_info).values(Calories=0,
                                                         Fat=0, Carbs=0,
                                                         Protein=0,
                                                         Sugar=0,
                                                         Sodium=0,
                                                         Iron=0,
                                                         Username=username)
    insert_userprefs = db.insert(user_preferences).values(Calories=0,
                                                          Fat=0, Carbs=0,
                                                          Protein=0, Sugar=0,
                                                          Sodium=0, Iron=0,
                                                          Username=username)
    connection.execute(insert_userinfo)
    connection.execute(insert_nutrinfo)
    connection.execute(insert_userprefs)
    return 0
