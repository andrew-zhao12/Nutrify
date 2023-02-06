import sqlalchemy as db

'''
function that will be called when a user attempts to login
will return 1 if username doesn't exist
will return 2 if username and password do not match
otherwise will return 0 after successful login
'''


def login(username, password):
    engine = db.create_engine('mysql://root:Group94@localhost:3306/nutrify')
    connection = engine.connect()
    metadata = db.MetaData()
    user_info = db.Table('User Info', metadata, autoload=True,
                         autoload_with=engine)
    retrieve_users = db.select([db.func.count(user_info.columns.Username)])\
        .where(user_info.columns.Username == username)
    retrieve_users = connection.execute(retrieve_users).fetchall()
    if retrieve_users[0][0] == 0:
        return 1
    retrieve_password = db.select([user_info]).where(
        user_info.columns.Username == username)
    retrieve_password = connection.execute(retrieve_password).fetchall()
    if retrieve_password[0][1] != password:
        return 2
    return 0