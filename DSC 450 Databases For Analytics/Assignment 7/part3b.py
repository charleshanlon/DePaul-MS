import re

def ccValidate():
    regex = "(?:\d{4}[-\s]?){3}\d{4}\s(?:0?[1-9]|1[0-2])/(?=\d{2}$)\d{2}"

    cc1 = '1234 1234 1234 1234 01/23'
    cc2 = '12345 1234 1234 1234 01/23'
    cc3 = '1345-1234-1234-1234 11/20'
    cc4 = '1345 1234 1234-1234 11/20'
    cc5 = '1345-1234-1234-1234 12/21'
    cc6 = '1345-1234-1234-1234 112/21'
    cc7 = '1345-1234-1234-1234 12/210'
    cc8 = '1345123412341234 12/21'
    cc8 = '1345123412341234'
    cc9 = '1345'

    tests = [cc1, cc2, cc3, cc4, cc5, cc6, cc7, cc8, cc9]

    for test in tests:
        if re.match(regex, test):
            print(test + " is valid!")
        else:
            print(test + " is NOT valid")

ccValidate()