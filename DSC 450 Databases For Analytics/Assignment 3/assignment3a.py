import sqlite3

def buildCSV():
    f = open("3aoutput.txt", "w") # open file

    conn = sqlite3.connect('dsc450.db') # open db conection
    cursor = conn.cursor()

    table = cursor.execute('SELECT * FROM Animal')
    res = table.fetchall()

    for row in res :
        cleanRow = str(row).replace("'", '')
        f.write(cleanRow[1:-1])
        f.write('\n')

    f.close()
    conn.close()

buildCSV()