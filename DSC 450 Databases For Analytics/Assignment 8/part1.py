import pandas as pd
import numpy

def employeesPandas():
    randn = numpy.random.randn

    names = ['FirstName', 'MiddleInitial', 'LastName', 'SSN', 'DOB', 'Address', 'City', 'State', 'Sex', 'Pay', 'SupervisorSSN', 'DeptId']

    employees = pd.read_csv("Employee.txt", names=names)

    df = pd.DataFrame(data = employees)

    #print(df)

    #find males
    males = df[df['Sex'] == 'M']
    print('All male employees:')
    print(males)
    print('-'*30)

    #find highest salary for females
    highFemale = df[df['Sex'] == 'F']['Pay'].max()
    print('Highest female salary:')
    print(highFemale)
    print('-'*30)

    #salary groups
    dg = df['Pay'].groupby(df['MiddleInitial'])
    print('Salaries for each middle initial')
    for gname, gvalue in dg:
        print('Middle initial: ' + gname)
        print(gvalue)
        print('\n')
    print('-'*30)

employeesPandas()