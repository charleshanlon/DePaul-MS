def validateInsert(txt) :

    if txt.startswith("INSERT INTO") and txt.endswith(";") :
        tail = txt.split(' (')
        return 'Inserting (' + tail[1][:-1] + ' into ' + txt.split(' ')[2] + ' table'
    else :
        return 'Invalid insert'

print(validateInsert("INSERT INTO Students VALUES (1, 'Jane', 'B+');"))
print(validateInsert("INSERT INTO Students VALUES (1, 'Jane', 'B+')"))
print(validateInsert("INSERT INTO Phones VALUES (42, '312-667-1213');"))
                     
