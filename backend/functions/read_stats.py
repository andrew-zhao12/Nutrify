'''
Function to retrieve numeric values on label from the converted string.
Parameters: convertedImg -> string (converted image)
Returns: list -> calories, fat, carbohydrates, protein, and sugar in
    grams, sodium and iron in milligrams
'''


def getFromImage(convertedImg):
    checkString = convertedImg.lower()
    checkString = checkString.replace(" ", "")
    calIndex = checkString.index("calories") + 8
    calories = ""
    while checkString[calIndex].isnumeric():
        calories += checkString[calIndex]
        calIndex += 1
    fatIndex = checkString.index("totalfat") + 8
    fat = ""
    while checkString[fatIndex].isnumeric():
        fat += checkString[fatIndex]
        fatIndex += 1
    carbIndex = checkString.index("totalcarbohydrate") + \
        len("totalcarbohydrate")
    carb = ""
    while checkString[carbIndex].isnumeric():
        carb += checkString[carbIndex]
        carbIndex += 1
    sugarIndex = checkString.index("totalsugars") + len("totalsugars")
    sugar = ""
    while checkString[sugarIndex].isnumeric():
        sugar += checkString[sugarIndex]
        sugarIndex += 1
    proteinIndex = checkString.index("protein") + len("protein")
    protein = ""
    while checkString[proteinIndex].isnumeric():
        protein += checkString[proteinIndex]
        proteinIndex += 1
    sodiumIndex = checkString.index("sodium") + len("sodium")
    sodium = ""
    while checkString[sodiumIndex].isnumeric():
        sodium += checkString[sodiumIndex]
        sodiumIndex += 1
    ironIndex = checkString.index("iron") + 4
    iron = ""
    while checkString[ironIndex].isnumeric():
        iron += checkString[ironIndex]
        ironIndex += 1
    listOf = [calories, fat, carb, protein, sugar, sodium, iron]
    numericArr = []
    for i in range(len(listOf)):
        if listOf[i] == "":
            listOf[i] = 0  # check for bad read
        numericArr.append(int(listOf[i]))
    return numericArr
