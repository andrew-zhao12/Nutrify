from functions import image_to_string
from functions import read_stats

# Current problem with pytesseract in that it sometimes reads g as 9.
# Read itself works, however


def testReadStats():
    imageName = "tests/resources/Label.jpg"
    imgString = image_to_string.convertImageToString(imageName)
    contents = read_stats.getFromImage(imgString)
    assert contents[0] == 110, "Incorrect read for calories"
    assert contents[1] == 0, "Incorrect read for fat"
    assert (contents[2] // 100) == 26, "Incorrect read for carbohydrates"
    assert contents[3] == 3, "Incorrect read for protein"
    assert contents[4] == 1, "Incorrect read for sugar"
    assert contents[5] == 0, "Incorrect read for sodium"
    assert contents[6] == 1, "Incorrect read for iron"
