import sqlite3

def assignmentPartTwo():

    createTablePerson = """
  CREATE TABLE Person
  (
    FirstName      VARCHAR2(30) NOT NULL,
    LastName      VARCHAR2(30) NOT NULL,
    Adress        VARCHAR2(100),
    JobType        VARCHAR2(30),

    CONSTRAINT Person_PK
      PRIMARY KEY(FirstName, LastName)
  );
  """
    createTableJob = """
  CREATE TABLE Jobs
  (
    Job             VARCHAR2(30),
    Salary          NUMBER(7, 0),
    Assistant       VARCHAR2(30),

    CONSTRAINT Jobs_PK
      PRIMARY KEY(Job),
    
    CONSTRAINT Jobs_FK
      FOREIGN KEY(Job)
      REFERENCES Person(JobType)
  );
  """
    dropTablePerson = "DROP TABLE IF EXISTS Person"
    dropTableJobs = "DROP TABLE IF EXISTS Jobs"

    #function begin

    f = open("data_module4_part2.txt", "r") # open file

    conn = sqlite3.connect('assignment4b.db') # open db conection
    cursor = conn.cursor()

    #table setup
    cursor.execute(dropTablePerson)
    cursor.execute(dropTableJobs)
    cursor.execute(createTablePerson)
    cursor.execute(createTableJob)
    
    allData = f.read()
    allDataLines = allData.split("\n")
    allDataLines = allDataLines[:-1]

    for data in allDataLines:
        tmp = data.split(', ')
        print(tmp)
        cursor.execute("INSERT OR IGNORE INTO Person VALUES(?,?,?,?)", tmp[:4])
        tmp = [None if value == 'NULL' else value for value in tmp]
        cursor.execute("INSERT OR IGNORE INTO Jobs VALUES(?,?,?)", tmp[3:])

    query1 = cursor.execute("SELECT * FROM Person;").fetchall()
    query2 = cursor.execute("SELECT * FROM Jobs;").fetchall()
    query3 = cursor.execute("SELECT Job FROM Jobs WHERE Salary IS NULL").fetchall()
    print('Testing Person')
    print(query1)
    print('--------------------------------------------------------------------')
    print('Testing Jobs')
    print(query2)
    print('--------------------------------------------------------------------')
    print('Testing for question D')
    print(query3)
    print('--------------------------------------------------------------------')


    f.close()
    conn.close()

assignmentPartTwo()
