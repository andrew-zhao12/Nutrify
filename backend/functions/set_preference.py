import sqlalchemy as db
import diet_preference_reader


def set_preference(calories, sugarDiet, biologicalSex, protein, carbs,
                   sodium, iron, username):
    calories, sugLow, sugUpp, fatLow, fatUpp, protein, carbs = \
        diet_preference_reader.dietPreferenceReader(calories, sugarDiet,
                                                    biologicalSex,
                                                    protein, carbs)
    engine = db.create_engine('mysql://root:Group94@localhost:3306/nutrify')
    connection = engine.connect()
    metadata = db.MetaData()
    user_preferences = db.Table('User Preferences', metadata, autoload=True,
                                 autoload_with=engine)
    calUp = db.update(user_preferences).values(Calories=calories).where(user_preferences.columns.Username == username)
    fatUp = db.update(user_preferences).values(Fat=fatUpp).where(user_preferences.columns.Username == username)
    carbUp = db.update(user_preferences).values(Carbs=carbs).where(user_preferences.columns.Username == username)
    protUp = db.update(user_preferences).values(Protein=protein).where(user_preferences.columns.Username == username)
    sugUp = db.update(user_preferences).values(Sugar=sugUpp).where(user_preferences.columns.Username == username)
    sodUp = db.update(user_preferences).values(Sodium=sodium).where(user_preferences.columns.Username == username)
    ironUp = db.update(user_preferences).values(Iron=iron).where(user_preferences.columns.Username == username)
    connection.execute(calUp)
    connection.execute(fatUp)
    connection.execute(carbUp)
    connection.execute(protUp)
    connection.execute(sugUp)
    connection.execute(sodUp)
    connection.execute(ironUp)