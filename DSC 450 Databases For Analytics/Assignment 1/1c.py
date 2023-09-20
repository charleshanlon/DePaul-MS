def generateInsert(table, params) :
    tail = ','.join(params)
    return "INSERT INTO " + table + " VALUES" + " (" + tail + ")"


print(generateInsert('Students', ['1', 'Jane', 'B+']))
