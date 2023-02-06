# -*- coding: utf-8 -*-
from PIL import Image
import pytesseract

def convertImageToString(imgName):
    imgString = pytesseract.image_to_string(Image.open(imgName))
    return imgString

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


def testContentOfStrings():
    pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'
    imageName = "tests/resources/eng_bw.png"
    firstString = convertImageToString(imageName)
    imageName = "tests/resources/Label.jpg"
    secondString = convertImageToString(imageName)
    print(firstString)
    print(secondString)
    print(getFromImage(secondString))
    assert firstString[0:14] == "Mild Splendour", "Incorrect reading of " \
        "example text"
    assert secondString[0:15] == "Nutrition Facts", "Incorrect reading of " \
        "example label"
    assert "Total Fat" in secondString, "Missing from Middle of Label"
    assert "Potassium" in secondString, "Missing from End of Label"

testContentOfStrings()
