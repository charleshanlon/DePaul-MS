CREATE TABLE Students(
    StudentId NUMBER(10),
    FirstName VARCHAR2(15),
    LastName VARCHAR2(25),
    DOB DATE,
    Phone VARCHAR2(12),
    Advisor NUMBER(5),
    
    CONSTRAINT S_PK
        PRIMARY KEY (StudentId),
        
    CONSTRAINT S_FK
        FOREIGN KEY (Advisor)
         REFERENCES Advisors(AdvisorId)
);

CREATE TABLE Advisors(
    AdvisorId NUMBER(5),
    Name VARCHAR2(25),
    Address VARCHAR2(25),
    Area VARCHAR2(15),
    Department VARCHAR2(25),
    
    CONSTRAINT Adv_PK
        PRIMARY KEY (AdvisorId),
    
    CONSTRAINT Adv_FK1
        FOREIGN KEY (Department)
        REFERENCES Departments(Name)
);

CREATE TABLE Departments(
    Name VARCHAR2(25),
    Chair VARCHAR2(15),
    CollegeId NUMBER(3),
    
    CONSTRAINT D_PK
        PRIMARY KEY (Name),
        
    CONSTRAINT D_FK
        FOREIGN KEY (CollegeId)
         REFERENCES Colleges(CollegeId)
);

CREATE TABLE Colleges(
    CollegeId NUMBER(3),
    Name VARCHAR2(30),
    
    CONSTRAINT C_PK
        PRIMARY KEY (CollegeId)
);


            