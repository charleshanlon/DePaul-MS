import sqlite3

def buildTableFromCSV():
    f = open("3aoutput.txt", "r") # open file

    conn = sqlite3.connect('3btest.db') # open db conection
    cursor = conn.cursor()
    
    allData = f.read()
    allDataLines = allData.split("\n")
    allDataLines = allDataLines[:-1]

    for line in allDataLines:
        line = line.split(', ')
        cursor.executemany("INSERT INTO Animal (AID, AName, ACategory, TimeToFeed) VALUES (?, ?, ?, ?);", (line,))

    check = cursor.execute('SELECT * FROM Animal')
    print(check.fetchall())

    f.close()
    conn.close()

buildTableFromCSV()
