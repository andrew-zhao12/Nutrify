import sqlalchemy as db
# from datetime import date
# import time

# function that sets all values in all columns of running total to 0
# except username


def resetRunningTotal():
    engine = db.create_engine('mysql://root:Group94@localhost:3306/nutrify')
    connection = engine.connect()
    metadata = db.MetaData()
    nutritional_info = db.Table('Running Total on Daily Nutrition', metadata,
                                autoload=True, autoload_with=engine)
    calUp = db.update(nutritional_info).values(Calories=0)
    fatUp = db.update(nutritional_info).values(Fat=0)
    carbUp = db.update(nutritional_info).values(Carbs=0)
    protUp = db.update(nutritional_info).values(Protein=0)
    sugUp = db.update(nutritional_info).values(Sugar=0)
    sodUp = db.update(nutritional_info).values(Sodium=0)
    ironUp = db.update(nutritional_info).values(Iron=0)
    connection.execute(calUp)
    connection.execute(fatUp)
    connection.execute(carbUp)
    connection.execute(protUp)
    connection.execute(sugUp)
    connection.execute(sodUp)
    connection.execute(ironUp)

# continuously running script that checks if the date has changed every hour,
# if so then call resetRunningTotal
'''
currdate = date.today()
while True:
    if currdate != date.today():
        resetRunningTotal()
        currdate = date.today()
    time.sleep(3600)
'''
# currently commented out since infinite loop doesn't work

