# -*- coding: utf-8 -*-
from PIL import Image
import pytesseract
'''
Function to convert an image of a specified name to a string ("example.jpg").
The string will be stored in a list so that it can be later modified by users
as they wish and accessed by the function to read data from the string.

Parameters: imgName -> string (Name of image file)
Returns: imgString -> string (converted string from image)
'''


def convertImageToString(imgName):
    imgString = pytesseract.image_to_string(Image.open(imgName))
    return imgString
