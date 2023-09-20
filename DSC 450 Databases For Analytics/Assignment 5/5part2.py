import sqlite3
import csv

def csvAutomator():
    createTableChauffer = """
  CREATE TABLE Chauffer
  (
    LicenseNum          Number(10) NOT NULL,
    Renewed             DATE,      
    Status              VARCHAR2(8) NOT NULL,
    StatusDate          DATE,
    DriverType          VARCHAR2(20) NOT NULL,
    LicenseType         VARCHAR(10),
    IssDate             DATE,
    Name                VARCHAR2(100) NOT NULL,
    Sex                 VARCHAR(10) NOT NULL,
    City                VARCHAR2(50) NOT NULL,
    State               VARCHAR2(2) NOT NULL,
    RecordNum           VARCHAR(20) NOT NULL,

    CONSTRAINT Chauffer_PK
      PRIMARY KEY(LicenseNum)
  );
  """
    dropTableChauffer = "DROP TABLE IF EXISTS Chauffer"
    
    

    conn = sqlite3.connect('5chauffeur.db') # open db conection
    cursor = conn.cursor()
    fd = open('Public_Chauffeurs_Short_hw3.csv', 'r')
    reader = csv.reader(fd)

    # Table setup
    cursor.execute(dropTableChauffer)
    cursor.execute(createTableChauffer)

    for row in reader:
        row = [None if value == 'NULL' else value for value in row]
        fixname = row[7].split(', ')
        if len(fixname) > 1:
            fix = fixname[1] + ' ' + fixname[0]
            row[7] = fix
        cursor.execute("INSERT OR IGNORE INTO Chauffer VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", row)
        #print(row)
    fd.close()

    test1 = cursor.execute("SELECT * FROM Chauffer;").fetchall()
    test2 = cursor.execute("SELECT * FROM Chauffer WHERE Name = 'GHASSAN FREIHAT' OR  Name = 'SEBLEWORK MANAYE BAYOU' OR Name = 'ALEX E. LUCERO' ;").fetchall()
    print(test1)
    print("------------------------------------------------------------------------------------------------------")
    print(test2)
    conn.close()

csvAutomator()
