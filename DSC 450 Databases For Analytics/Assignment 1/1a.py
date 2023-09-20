def averageCalc(file) :
    sum = 0
    count=0

    fd = open(file)
    lines = fd.readlines()

    for line in lines:
        vals = line.split(',')
        for val in vals:
            sum = sum + int(val)
            count+=1
    
    res = sum/count
    print(res)
    return res

averageCalc('data.txt')