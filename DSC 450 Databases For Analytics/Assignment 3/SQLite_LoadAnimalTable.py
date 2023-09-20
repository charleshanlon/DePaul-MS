import sqlite3

def buildAssingmentDatabase() :
  createtbl = """
  CREATE TABLE Person
  (
    PID             NUMBER(3, 0),
    FirstName      VARCHAR2(30) NOT NULL,
    LastName      VARCHAR2(30) NOT NULL,
    Adress        VARCHAR2(100),

    CONSTRAINT Person_PK
      PRIMARY KEY(PID)
  );
  """

  inserts = ["INSERT INTO Animal VALUES(1, 'Galapagos Penguin', 'exotic', 0.5);", "INSERT INTO Animal VALUES(2, 'Emperor Penguin', 'rare', 0.75);", "INSERT INTO Animal VALUES(3, 'Sri Lankan sloth bear', 'exotic', 2.5);", "INSERT INTO Animal VALUES(4, 'Grizzly bear', 'common', 3.0);", "INSERT INTO Animal VALUES(5, 'Giant Panda bear', 'exotic', 1.5);", "INSERT INTO Animal VALUES(6, 'Florida black bear', 'rare', 1.75);", "INSERT INTO Animal VALUES(7, 'Siberian tiger', 'rare', 3.25);", "INSERT INTO Animal VALUES(8, 'Bengal tiger', 'common', 2.75);", "INSERT INTO Animal VALUES(9, 'South China tiger', 'exotic', 2.5);", "INSERT INTO Animal VALUES(10, 'Alpaca', 'common', 0.25);", "INSERT INTO Animal VALUES(11, 'Llama', NULL, 3.5);"]

  conn = sqlite3.connect('3btest.db') # open the connection
  cursor = conn.cursor()

  cursor.execute(createtbl)   # create the Animal table
  # for ins in inserts:         # insert the rows
      # cursor.execute(ins)
  
  check = cursor.execute('SELECT * FROM Animal')
  print(check.fetchall())

  conn.commit()   # finalize inserted data
  conn.close()    # close the connection

buildAssingmentDatabase()

  