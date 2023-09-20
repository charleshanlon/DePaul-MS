import sqlite3

def fakeSql():
    word = 'bear'
    f = open("animal.txt", "r") # open file

    conn = sqlite3.connect('assignment41.db') # open db conection
    cursor = conn.cursor()
    
    allData = f.read()
    allDataLines = allData.split("\n")
    allDataLines = allDataLines[:-1]

    for data in allDataLines:
        if word in data and 'common' not in data:
            tmp = data.split(', ')
            print(tmp[1], tmp[2])


    f.close()
    conn.close()

fakeSql()
