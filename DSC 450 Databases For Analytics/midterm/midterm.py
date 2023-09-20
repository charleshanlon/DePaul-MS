import sqlite3
import statistics

def midterm():
    # define tables 
    createTableStudent = """
  CREATE TABLE Student
  (
    StudentID       NUMBER(8) NOT NULL,
    Name            VARCHAR2(30) NOT NULL,
    Address          VARCHAR2(100),
    GradYear        NUMBER(4),

    CONSTRAINT S_PK
      PRIMARY KEY(StudentID)
  );
  """
    createTableGrade = """
  CREATE TABLE Grade
  (
    CName          VARCHAR2(50) NOT NULL,
    StudentID      NUMBER(8) NOT NULL,
    CGrade         NUMBER(5,2),

    CONSTRAINT G_PK
      PRIMARY KEY(CName,StudentID),

    CONSTRAINT G1_FK
      FOREIGN KEY(StudentID)
      REFERENCES Student(StudentID),
    
    CONSTRAINT G2_FK
      FOREIGN KEY(CName)
      REFERENCES Course(CName)
  );
  """
    createTableCourse = """
  CREATE TABLE Course
  (
    CName       VARCHAR2(50) NOT NULL,
    Department  VARCHAR2(50),
    Credits     NNUMBER(2),

    CONSTRAINT C_PK
      PRIMARY KEY(CName)
  );
  """
    dropTableStudent = "DROP TABLE IF EXISTS Student"
    dropTableGrade = "DROP TABLE IF EXISTS Grade"
    dropTableCourse = "DROP TABLE IF EXISTS Course"

    f = open("midterm.txt", "w")
    conn = sqlite3.connect('midterm.db') # open db conection
    cursor = conn.cursor()

    # reset tables
    cursor.execute(dropTableCourse)
    cursor.execute(dropTableStudent)
    cursor.execute(dropTableGrade)

    # create tables
    cursor.execute(createTableStudent)
    cursor.execute(createTableCourse)
    cursor.execute(createTableGrade)


    # insert phony data
    cursor.execute("INSERT OR IGNORE INTO Student VALUES(?,?,?,?)", [12, 'Josh Smith', 'Main St. Chicago', 2026])
    cursor.execute("INSERT OR IGNORE INTO Student VALUES(?,?,?,?)", [16, 'Connor Joe', 'Main St. Pheonix', 2024])
    cursor.execute("INSERT OR IGNORE INTO Student VALUES(?,?,?,?)", [15, 'Miles Teller', 'Main St. Philadelphia', 2029])
    cursor.execute("INSERT OR IGNORE INTO Student VALUES(?,?,?,?)", [24, 'Pete Law', 'Main St. New York', 2025])
    cursor.execute("INSERT OR IGNORE INTO Student VALUES(?,?,?,?)", [19, 'Luke May', 'Main St. Detroit', 2024])

    cursor.execute("INSERT OR IGNORE INTO Course VALUES(?,?,?)", ['Calculus', 'Mathematics', 4])
    cursor.execute("INSERT OR IGNORE INTO Course VALUES(?,?,?)", ['Art History', 'Arts', 2])
    cursor.execute("INSERT OR IGNORE INTO Course VALUES(?,?,?)", ['Databases', 'Engineering', 4])
    cursor.execute("INSERT OR IGNORE INTO Course VALUES(?,?,?)", ['English', 'Arts', 4])

    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['English', 12, 99.80])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['Databases', 12, 90.00])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['Calculus', 12, 73.50])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['English', 15, 90.20])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['Databases', 16, 89.82])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['English', 19, 92.80])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['English', 19, 99.80])
    cursor.execute("INSERT OR IGNORE INTO Grade VALUES(?,?,?)", ['Calculus', 19, 100.00])

    # a)	Create a view that joins the three tables, including all of the records from student table (i.e., including the non-enrolled students).
    createView = """
    CREATE VIEW PartAView AS
    SELECT s.StudentID, s.Name, s.Address, s.GradYear, g.CName, g.CGrade, c.Department, c.Credits
    FROM Student s
    LEFT JOIN Grade g ON s.StudentID = g.StudentID
    LEFT JOIN Course c ON g.CName = c.CName;
    """

    data = cursor.execute(createView)
    data = cursor.execute("SELECT * FROM PartAView").fetchall()
    print(data)

    #b)	Write and execute python code that uses that view to export all data into a single .txt file 
    # (that is a “de-normalized” 1NF file with some redundancy present). 
    # This code should include NULLs due to the non-enrolled students.
    for row in data:
         row = str(row).replace("'", '')
         row = str(row).replace('None', 'NULL')
         print(row[1:-1])
         f.write(row[1:-1])
         f.write('\n')

    #c)	Add a new row to the de-normalized .txt file (you can manually edit the .txt file 
    # from part b) that violates the following functional dependency: CName -> Credits
    f.write("16, Connor Joe, Main St. Pheonix, 2024, Databases, 89.82, Engineering, 1")
    f.close()

    #d)	Write python code that will identify the values for which functional 
    # dependency was violated in your .txt file (hint: when the functional dependency 
    # is valid, there is only one unique value of Credits for each CName). 
    # Your solution should detect any violation of the CName  Credits functional dependency, 
    # not just your example. Keep in mind that functional dependency is 
    # violated only in the pre-joined .txt file, not in the SQLite database, 
    # so this solution must read data from .txt file.

    firstNF = open("midterm.txt", "r")
    dict = {}

    allData = firstNF.read()
    allDataLines = allData.split("\n")

    for data in allDataLines:
         data = data.split(', ')
         if data[4] not in dict:
            dict[data[4]] = data[7]
         elif dict[data[4]] != data[7]:
             print('Part 4d ERROR: CName:', data[4],'-> Credits:', data[7], 'FD violated!')   
    
    #e)	Suppose I have a new query: Qe: For every department, display the median and max graduation years.
    #1.	Use the view from Part 4-a to re-write query Qe 
    # (i.e., replace the tables in the query’s FROM clause by the view and rewrite the rest of the query accordingly to produce an answer).
    
    #2.	Use your .txt file containing de-normalized data from part-b to answer Qe with python instead of SQL. 
    # Note that this solution should not use SQLite or SQL language. 
    # Your solution should work for any input, not just for specific department in your data
    allDataLines = allDataLines[:-1]
    dict = {}
    for data in allDataLines:
        data = data.split(', ')
        dpt = data[6]
        yr = data[3]
        tmp = []

        if dpt != 'NULL':
            if dpt not in dict:
                dict[dpt] = []
            dict[dpt].append(int(yr))
    
    keys = list(dict.keys())
    
    for key in keys:
        print(key, '- Max:', max(dict[key]), 'Median:', int(statistics.median(dict[key])))


    
    print(dict)


midterm()

