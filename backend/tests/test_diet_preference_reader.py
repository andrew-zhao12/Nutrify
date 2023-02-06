from functions import diet_preference_reader


def testCalories():
    cals = 1000
    firstTup = diet_preference_reader.dietPreferenceReader(cals, "None", "N",
                                                           10, 10)
    assert type(firstTup) == tuple, "Incorrect type of return"
    assert firstTup[0] == 1000, "Incorrect value of calories (1000)"
    otherCals = 2000
    secondTup = diet_preference_reader.dietPreferenceReader(otherCals,
                                                            "None", "N",
                                                            10, 10)
    assert secondTup[0] == 2000, "Incorrect value of calories (2000)"


def testSugarRange():
    noneM = diet_preference_reader.dietPreferenceReader(2000, "None", "M",
                                                        20, 20)
    noneF = diet_preference_reader.dietPreferenceReader(2000, "None", "F",
                                                        20, 20)
    noneN = diet_preference_reader.dietPreferenceReader(2000, "None", "N",
                                                        20, 20)
    assert (noneM[1] == 0 and noneF[1] == 0 and noneN[1] == 0), \
        "Incorrect lower added sugar limit for none"
    assert (noneM[2] == 0 and noneF[2] == 0 and noneN[2] == 0), \
        "Incorrect upper added sugar limit for none"
    normalM = diet_preference_reader.dietPreferenceReader(
        2000, "Normal", "M", 20, 20)
    normalF = diet_preference_reader.dietPreferenceReader(
        2000, "Normal", "F", 20, 20)
    normalN = diet_preference_reader.dietPreferenceReader(
        2000, "Normal", "N", 20, 20)
    assert (normalM[1] == 0 and normalF[1] == 0 and normalN[1] == 0), \
        "Incorrect lower added sugar limit for normal"
    assert normalM[2] == 37, \
        "Incorrect upper added sugar limit for normal male"
    assert normalF[2] == 25, \
        "Incorrect upper added sugar limit for normal female"
    assert normalN[2] == 30, \
        "Incorrect upper added sugar limit for normal neither"


def testFatRange():
    mediumDiet = diet_preference_reader.dietPreferenceReader(1000, "None", "M",
                                                             30, 30)
    assert mediumDiet[3] == (0.25 * (1000 / 9)), \
        "Incorrect lower fat limit in grams for 1000 calories"
    assert mediumDiet[4] == (0.35 * (1000 / 9)), \
        "Incorrect upper fat limit in grams for 1000 calories"
    higherDiet = diet_preference_reader.dietPreferenceReader(2000, "None", "M",
                                                             30, 30)
    assert higherDiet[3] == (0.25 * (2000 / 9)), \
        "Incorrect lower fat limit in grams for 2000 calories"
    assert higherDiet[4] == (0.35 * (2000 / 9)), \
        "Incorrect upper fat limit in grams for 2000 calories"


def testProteinAndCarbs():
    diet = diet_preference_reader.dietPreferenceReader(1000, "None", "M",
                                                             500, 300)
    assert diet[5] == 500, "Incorrect proteins"
    assert diet[6] == 300, "Incorrect carbohydrates"
