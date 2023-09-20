def averageCalc(file) :

    fn = open("newfile.txt", "w")
    fd = open(file)
    lines = fd.readlines()

    for line in lines:
        line = line.strip()
        vals = line.split(',')
        for val in vals:
            fn.write(val+"\n")
    fn.close()

averageCalc('data.txt')