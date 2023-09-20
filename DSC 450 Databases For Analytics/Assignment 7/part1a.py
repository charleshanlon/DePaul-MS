import random
import pandas
import numpy

nums = [99, 41, 83, 71, 58, 83, 44, 99, 56, 29, 44, 44, 52, 81, 30, 83, 76, 39, 80, 36, 35, 73, 73, 46, 71, 45, 59, 39, 47, 63, 89, 57, 43, 98, 98, 65, 70, 71, 82, 70, 76, 33, 61, 65, 34, 33, 94, 71, 39, 64, 61, 98, 71, 49, 72, 29, 92, 94, 32, 92, 59, 73, 96, 48, 50, 31, 37, 62, 97, 54, 55, 34, 34, 52, 49, 84, 34, 52, 47, 71, 58, 79, 89, 66, 85, 67, 82, 50, 40, 77]

def generateNums(x):
    res = []
    for i in range(x):
        res.append(random.randrange(27,100))
    
    return res

def analyzeNums(nums):
    series = pandas.Series(nums)
    res = len(series[series < 44])

    return res

def modifyNums(nums):
    arr = numpy.reshape(nums, (9,10))
    arr[arr >= 44] = 44
    
    return arr

print(analyzeNums(nums))

print(modifyNums(nums))