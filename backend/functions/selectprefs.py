from ftfy import warnings
import sqlalchemy as db
from sqlalchemy.sql import select
import numpy as np

'''
Warning system that return a dictionary of warnings for each nutritional category based on
daily running total and the users preferences
Will return a True warning if the goal for that category based on whether its under/over the limit
(over for most categories, under for protein and iron)
'''

def warningSystem(calories, sugarDiet, biologicalSex, fat, bodyWeight, protein, carbs, username):
    engine = db.create_engine('mysql://root:Group94@localhost:3306/Nutrify')
    connection = engine.connect()
    metadata = db.MetaData()
    user_preferences = db.Table("User Preferences", metadata, autoload=True, autoload_with = engine)
    nutritional_info = db.Table("Running Total on Daily Nutrition", metadata, autoload = True, autoload_with = engine)
    data = db.select([nutritional_info]).where(nutritional_info.columns.Username == username)
    data = connection.execute(data).fetchall()
    preferences = db.select([user_preferences]).where(user_preferences.columns.Username == username)
    preferences = connection.execute(preferences).fetchall()
    warningDict = {"Calories": False, "Fat": False, "Sugar": False, "Protein" : False, "Carbs" : False, "Sodium" : False, "Iron" : False}
    if (data[0][0] >= preferences[0][0]):
        warningDict["Calories"] = True
    if (data[0][1] >= preferences[0][1]):
        warningDict["Fat"] = True
    if (data[0][4] >= preferences[0][4]):
        warningDict["Sugar"] = True
    if (data[0][3] <= protein):
        warningDict["Protein"] = True
    if (data[0][2] >= carbs):
        warningDict["Carbs"] = True
    if (data[0][5] >= preferences[0][5]):
        warningDict["Sodium"] = True
    if (data[0][6] <= preferences[0][6]):
        warningDict["Iron"] = True
    
    return warningDict