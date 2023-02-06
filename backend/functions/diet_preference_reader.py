# -*- coding: utf-8 -*-
'''
Function to take the number of calories the user wishes to limit themself to,
whether the user wants to follow a no added sugar or normal sugar diet, and
the biological sex of the user to return a tuple with the range information of
the person's diet. The calories are preserved as inputted, but the range of
added sugars is calculated based on the biological sex of the user. The lower
and upper limits of fat intake are calculated based on the dietary reference
of a healthy low fat diet that between 25% and 35% of caloric intake should
come from fat.

Parameters:
    calories -> int (amount of calories the user plans to intake)
    sugarDiet -> string (type of adder sugar diet the user wishes to follow
                         ("None" or "Normal"))
    biologicalSex -> string (biological sex of the user ("M", "F", or "N"))
Return:
    (calories, sugarLowerRange, sugarUpperRange, lowerFat, upperFat, protein,
    carbs) -> tuple (data about the accepted ranges of caloric, added sugar,
                fat intake, protein, and carbohydrates respectively based on
                inputs with the caloric intake measured in calories and
                everyting else measured in grams)
'''


def dietPreferenceReader(calories, sugarDiet, biologicalSex, protein, carbs):
    sugarLowerRange = 0
    sugarUpperRange = 0
    if sugarDiet == "Normal":
        if biologicalSex == "M":
            sugarUpperRange = 37
        elif biologicalSex == "F":
            sugarUpperRange = 25
        else:
            sugarUpperRange = 30
    totalFatPerCalories = calories / 9
    lowerFat = 0.25 * totalFatPerCalories
    upperFat = 0.35 * totalFatPerCalories
    return (calories, sugarLowerRange, sugarUpperRange, lowerFat, upperFat,
            protein, carbs)
