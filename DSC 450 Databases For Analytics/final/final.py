import sqlite3
import json
import urllib.request
import time
import re
import pandas as pd

def finalFunc():
    #1a
    tweetData = 'http://dbgroup.cdm.depaul.edu/DSC450/OneDayOfTweets.txt'
    # print('loading tweets file took (130k, 650k): ' + str(downloadTweets(tweetData, 650000, 'tweets.txt')))

    #1b
    #print('tweets db write took (130k, 650k): ' + str(tweetsToDb(tweetData)))

    #1c
    #print('tweets db write from txt took (130k, 650k): ' + str(tweetsToDbfromTxt('tweets.txt')))

    #1d
    # print('tweets db write (batches) took (130k, 650k): ' + str(tweetsToDbBatch(tweetData)))

    #2
    #partTwoA()
    #print('Times (1, 5, 20):', partTwoF())
    #partTwoE('tweets.txt')

    partThreeC()

def downloadTweets(url, count, file):
    webFd = urllib.request.urlopen(url)
    fd = open(file, 'w+', encoding="utf")

    start = time.time()

    ct = 1
    for tweet in webFd:
        fd.write(tweet.decode('UTF-8'))
        if ct == 130000:
            end130 = time.time()
        if ct == 650000:
            end650 = time.time()
            break
        print(ct)
        ct += 1

    fd.close()
    webFd.close()
    return end130 - start, end650 - start

def tweetsToDb(url):
    createTableTweets = """
  CREATE TABLE Tweets
  (
    CreatedOn           VARCHAR2(50),
    TweetId             VARCHAR2(50) NOT NULL,
    UserId              NUMBER(50) NOT NULL,
    GeoId               VARCHAR2(50),
    Body                VARCHAR2(200),
    Source              VARCHAR2(200),
    ReplyToUser         VARCHAR2(50),
    ReplyToName         VARCHAR(100),
    ReplyToStatus       VARCHAR(100),
    Retweets            NUMBER(10),
    Contributors        VARCHAR(100),

    CONSTRAINT Tweets_PK
      PRIMARY KEY(TweetId),
    
    CONSTRAINT Tweets_FK
      FOREIGN KEY(UserId)
      REFERENCES User(Id),

    CONSTRAINT Tweets_FK2
      FOREIGN KEY(GeoId)
      REFERENCES Geo(Id)
  );
  """
    createTableUsers = """
  CREATE TABLE Users
  (
    Id                  NUMBER(50) NOT NULL,
    Name                VARCHAR2(100),
    ScreenName          VARCHAR2(100),
    Description         VARCHAR2(140),
    FriendsCount        NUMBER(50),
    

    CONSTRAINT Users_PK
      PRIMARY KEY(Id)
  );
  """
    createTableGeo = """
  CREATE TABLE Geo
  (
    Id                  VARCHAR2(50) NOT NULL,
    Type                VARCHAR2(100),
    Longitude           NUMBER(100),
    Latitude            NUMBER(140),
    

    CONSTRAINT Geo_PK
      PRIMARY KEY(Id)
  );
  """
    
    dropTableTweets = "DROP TABLE IF EXISTS Tweets"
    dropTableUsers = "DROP TABLE IF EXISTS Users"
    dropTableGeo = "DROP TABLE IF EXISTS Geo"
    print('hi')
    conn = sqlite3.connect('final.db') # open db conection 
    cursor = conn.cursor()

    cursor.execute(dropTableTweets)
    cursor.execute(dropTableUsers)
    cursor.execute(dropTableGeo)
    cursor.execute(createTableGeo)
    cursor.execute(createTableUsers)
    cursor.execute(createTableTweets)
    print('hi')
    #tweetData = url
    #webFD = urllib.request.urlopen(url)
    #tweets = webFD.readlines(

    ct = 1
    start = time.time()
    tweets = urllib.request.urlopen(url)

    for tweet in tweets:
        currGeo = []
        try:
            #print(tweet)
            tmp = json.loads(tweet.decode('utf-8'))

            if tmp['geo'] is not None:
                geoId = str(tmp['geo']['coordinates'][0]) + str(tmp['geo']['coordinates'][1])
                currGeo = [geoId, tmp['geo']['type'], tmp['geo']['coordinates'][0], tmp['geo']['coordinates'][1]]
            else:
                geoId = None
            
            tmpDate = tmp["created_at"].split(' ')
            cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
            currTweet = [cleanDate, tmp["id_str"], tmp['user']['id'], geoId, tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"]]
            currUser = [tmp['user']['id'], tmp['user']['name'], tmp['user']['screen_name'], tmp['user']['description'], tmp['user']['friends_count']]
            cursor.execute("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?,?,?)", currTweet)
            print(ct)
            cursor.execute("INSERT OR IGNORE INTO Users VALUES(?,?,?,?,?)", currUser)
            if len(currGeo) > 0:
                cursor.execute("INSERT OR IGNORE INTO Geo VALUES(?,?,?,?)", currGeo)

        except ValueError:
            print('error')
        if ct == 130000:
            end130 = time.time()
        if ct == 650000:
            break
        print(ct)
        ct += 1
    end650 = time.time()
    
    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    test2 = cursor.execute("SELECT COUNT(*) FROM Users;").fetchall()
    test3 = cursor.execute("SELECT COUNT(*) FROM Geo;").fetchall()
    print(test1)
    print(test2)
    print(test3)

    conn.commit()

    return end130 - start, end650 - start

def tweetsToDbfromTxt(file):
    createTableTweets = """
  CREATE TABLE Tweets
  (
    CreatedOn           VARCHAR2(50),
    TweetId             VARCHAR2(50) NOT NULL,
    UserId              NUMBER(50) NOT NULL,
    GeoId               VARCHAR2(50),
    Body                VARCHAR2(200),
    Source              VARCHAR2(200),
    ReplyToUser         VARCHAR2(50),
    ReplyToName         VARCHAR(100),
    ReplyToStatus       VARCHAR(100),
    Retweets            NUMBER(10),
    Contributors        VARCHAR(100),

    CONSTRAINT Tweets_PK
      PRIMARY KEY(TweetId),
    
    CONSTRAINT Tweets_FK
      FOREIGN KEY(UserId)
      REFERENCES User(Id),

    CONSTRAINT Tweets_FK2
      FOREIGN KEY(GeoId)
      REFERENCES Geo(Id)
  );
  """
    createTableUsers = """
  CREATE TABLE Users
  (
    Id                  NUMBER(50) NOT NULL,
    Name                VARCHAR2(100),
    ScreenName          VARCHAR2(100),
    Description         VARCHAR2(140),
    FriendsCount        NUMBER(50),
    

    CONSTRAINT Users_PK
      PRIMARY KEY(Id)
  );
  """
    createTableGeo = """
  CREATE TABLE Geo
  (
    Id                  VARCHAR2(50) NOT NULL,
    Type                VARCHAR2(100),
    Longitude           NUMBER(100),
    Latitude            NUMBER(140),
    

    CONSTRAINT Geo_PK
      PRIMARY KEY(Id)
  );
  """
    
    dropTableTweets = "DROP TABLE IF EXISTS Tweets"
    dropTableUsers = "DROP TABLE IF EXISTS Users"
    dropTableGeo = "DROP TABLE IF EXISTS Geo"
    print('hi')
    conn = sqlite3.connect('final.db') # open db conection 
    cursor = conn.cursor()

    cursor.execute(dropTableTweets)
    cursor.execute(dropTableUsers)
    cursor.execute(dropTableGeo)
    cursor.execute(createTableGeo)
    cursor.execute(createTableUsers)
    cursor.execute(createTableTweets)
    print('hi')
    #tweetData = url
    #webFD = urllib.request.urlopen(url)
    #tweets = webFD.readlines(

    ct = 1
    start = time.time()
    tweets = open(file, 'r', encoding="utf")

    for tweet in tweets:
        currGeo = []
        try:
            #print(tweet)
            tmp = json.loads(tweet)

            if tmp['geo'] is not None:
                geoId = str(tmp['geo']['coordinates'][0]) + str(tmp['geo']['coordinates'][1])
                currGeo = [geoId, tmp['geo']['type'], tmp['geo']['coordinates'][0], tmp['geo']['coordinates'][1]]
            else:
                geoId = None
            
            tmpDate = tmp["created_at"].split(' ')
            cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
            currTweet = [cleanDate, tmp["id_str"], tmp['user']['id'], geoId, tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"]]
            currUser = [tmp['user']['id'], tmp['user']['name'], tmp['user']['screen_name'], tmp['user']['description'], tmp['user']['friends_count']]
            cursor.execute("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?,?,?)", currTweet)
            print(ct)
            cursor.execute("INSERT OR IGNORE INTO Users VALUES(?,?,?,?,?)", currUser)
            if len(currGeo) > 0:
                cursor.execute("INSERT OR IGNORE INTO Geo VALUES(?,?,?,?)", currGeo)

        except ValueError:
            print('error')
        if ct == 130000:
            end130 = time.time()
        print(ct)
        ct += 1
    end650 = time.time()
    
    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    test2 = cursor.execute("SELECT COUNT(*) FROM Users;").fetchall()
    test3 = cursor.execute("SELECT COUNT(*) FROM Geo;").fetchall()
    print(test1)
    print(test2)
    print(test3)

    conn.commit()

    return end130 - start, end650 - start

def tweetsToDbBatch(url):
    createTableTweets = """
  CREATE TABLE Tweets
  (
    CreatedOn           VARCHAR2(50),
    TweetId             VARCHAR2(50) NOT NULL,
    UserId              NUMBER(50) NOT NULL,
    GeoId               VARCHAR2(50),
    Body                VARCHAR2(200),
    Source              VARCHAR2(200),
    ReplyToUser         VARCHAR2(50),
    ReplyToName         VARCHAR(100),
    ReplyToStatus       VARCHAR(100),
    Retweets            NUMBER(10),
    Contributors        VARCHAR(100),

    CONSTRAINT Tweets_PK
      PRIMARY KEY(TweetId),
    
    CONSTRAINT Tweets_FK
      FOREIGN KEY(UserId)
      REFERENCES User(Id),

    CONSTRAINT Tweets_FK2
      FOREIGN KEY(GeoId)
      REFERENCES Geo(Id)
  );
  """
    createTableUsers = """
  CREATE TABLE Users
  (
    Id                  NUMBER(50) NOT NULL,
    Name                VARCHAR2(100),
    ScreenName          VARCHAR2(100),
    Description         VARCHAR2(140),
    FriendsCount        NUMBER(50),
    

    CONSTRAINT Users_PK
      PRIMARY KEY(Id)
  );
  """
    createTableGeo = """
  CREATE TABLE Geo
  (
    Id                  VARCHAR2(50) NOT NULL,
    Type                VARCHAR2(100),
    Longitude           NUMBER(100),
    Latitude            NUMBER(140),
    

    CONSTRAINT Geo_PK
      PRIMARY KEY(Id)
  );
  """
    
    dropTableTweets = "DROP TABLE IF EXISTS Tweets"
    dropTableUsers = "DROP TABLE IF EXISTS Users"
    dropTableGeo = "DROP TABLE IF EXISTS Geo"
    print('hi')
    conn = sqlite3.connect('final.db') # open db conection 
    cursor = conn.cursor()

    cursor.execute(dropTableTweets)
    cursor.execute(dropTableUsers)
    cursor.execute(dropTableGeo)
    cursor.execute(createTableGeo)
    cursor.execute(createTableUsers)
    cursor.execute(createTableTweets)
    print('hi')
    #tweetData = url
    #webFD = urllib.request.urlopen(url)
    #tweets = webFD.readlines(

    ct = 1
    start = time.time()
    tweets = urllib.request.urlopen(url)

    batch_size = 2500
    tweet_batch = []
    user_batch = []
    geo_batch = []

    for tweet in tweets:
        try:
            #print(tweet)
            tmp = json.loads(tweet.decode('utf-8'))

            if tmp['geo'] is not None:
                geoId = str(tmp['geo']['coordinates'][0]) + str(tmp['geo']['coordinates'][1])
                geo_batch.append([geoId, tmp['geo']['type'], tmp['geo']['coordinates'][0], tmp['geo']['coordinates'][1]])
            else:
                geoId = None
            
            tmpDate = tmp["created_at"].split(' ')
            cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
            tweet_batch.append([cleanDate, tmp["id_str"], tmp['user']['id'], geoId, tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"]])
            user_batch.append([tmp['user']['id'], tmp['user']['name'], tmp['user']['screen_name'], tmp['user']['description'], tmp['user']['friends_count']])
            
            if ct % batch_size == 0:
                cursor.executemany("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?,?,?)", tweet_batch)
                cursor.executemany("INSERT OR IGNORE INTO Users VALUES(?,?,?,?,?)", user_batch)
                cursor.executemany("INSERT OR IGNORE INTO Geo VALUES(?,?,?,?)", geo_batch)

                tweet_batch = []
                user_batch = []
                geo_batch = []

        except ValueError:
            print('error')
        if ct == 130000:
            end130 = time.time()
        if ct == 650000:
            break
        print(ct)
        ct += 1
    
    if tweet_batch:
        cursor.executemany("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?,?,?)", tweet_batch)
    if user_batch:
        cursor.executemany("INSERT OR IGNORE INTO Users VALUES(?,?,?,?,?)", user_batch)
    if geo_batch:
        cursor.executemany("INSERT OR IGNORE INTO Geo VALUES(?,?,?,?)", geo_batch)

    end650 = time.time()
    
    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    test2 = cursor.execute("SELECT COUNT(*) FROM Users;").fetchall()
    test3 = cursor.execute("SELECT COUNT(*) FROM Geo;").fetchall()
    print(test1)
    print(test2)
    print(test3)

    return end130 - start, end650 - start

def partTwoA():
    conn = sqlite3.connect('final.db') # open db conection 
    cursor = conn.cursor()

    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    test2 = cursor.execute("SELECT COUNT(*) FROM Users;").fetchall()
    test3 = cursor.execute("SELECT COUNT(*) FROM Geo;").fetchall()
    print(test1)
    print(test2)
    print(test3)

    a = cursor.execute("""
    SELECT 
        UserId, AVG(Latitude) AS AvgLatitude, SUM(Latitude)/COUNT(Latitude) AS AvgLatitudeUsingSumCount
    FROM 
        Tweets 
    JOIN 
        Geo ON Tweets.GeoId = Geo.Id
    GROUP BY 
        UserId;
    """).fetchall()
    start = time.time()
    print(a)
    end = time.time()

    start5 = time.time()
    for i in range(5):
        print(a)
    end5 = time.time()

    start20 = time.time()
    for i in range(20):
        print(a)
    end20 = time.time()

    print('query executed 1 time: ' + str(end - start))
    print('query executed 5 times: ' + str(end5 - start5))
    print('query executed 20 times: ' + str(end20 - start20))

def partTwoC(file):
    tweets = open(file, 'r', encoding="utf")
    dict = {}
    start = time.time()
    ct = 1
    for tweet in tweets:
        try:
            tmp = json.loads(tweet)
            if tmp['geo'] is not None:
                if tmp['user']['id'] in dict:
                    dict[tmp['user']['id']].append(tmp['geo']['coordinates'][0])
                else :
                    dict[tmp['user']['id']] = [tmp['geo']['coordinates'][0]]
        except ValueError:
            print('error')
    end = time.time()
    for key, val in dict.items():
        print(key, (sum(val) / len(val)))
    end = time.time()
    print('time:', str(end - start))

def partTwoF():

    start1 = time.time()
    partTwoE('tweets.txt')
    end1 = time.time()

    start5 = time.time()
    for i in range(5):
        partTwoE('tweets.txt')
    end5 = time.time()

    start20 = time.time()
    for j in range(20):
        partTwoE('tweets.txt')
    end20 = time.time()

    return end1 - start1, end5 - start5, end20 - start20

def partTwoE(file):
    tweets = open(file, 'r', encoding="utf")
    userid_pattern = re.compile(r'"user":\{"id":(\d+),')
    geo_pattern = re.compile(r'"geo":\{"type":"Point","coordinates":\[(\d+\.\d+),\d+\.\d+\]\}')
    dict = {}
    start = time.time()
    ct = 1
    for tweet in tweets:
        try:
            userid_match = re.search(userid_pattern, tweet)
            userid = int(userid_match.group(1))
            geo_match = re.search(geo_pattern, tweet)
            if geo_match:
                lat = float(geo_match.group(1))
                if userid in dict:
                    dict[userid].append(lat)
                else:
                    dict[userid] = [lat]
        except ValueError:
            print('error')
    end = time.time()
    for key, val in dict.items():
        print(key, (sum(val) / len(val)))
    end = time.time()
    #print(dict)
    print('time:', str(end - start))

def partThreeA():
    conn = sqlite3.connect('final.db') # open db conection 
    cursor = conn.cursor()

    dropTable = "DROP TABLE IF EXISTS PseduoMV"
    cursor.execute(dropTable)

    pseudoMv = """
    CREATE TABLE PseduoMV AS
    SELECT 
        T.CreatedOn, T.TweetId, T.UserId, T.GeoId, T.Body, T.Source, T.ReplyToUser, T.ReplyToName, T.ReplyToStatus, T.Retweets, T.Contributors,
        U.Name, U.ScreenName, U.Description, U.FriendsCount,
        G.Type, G.Longitude, G.Latitude
    FROM 
        Tweets AS T
    LEFT JOIN 
        Users AS U ON T.UserId = U.Id
    LEFT JOIN 
        Geo AS G ON T.GeoId = G.Id;
    """

    cursor.execute(pseudoMv)
    conn.commit()

def partThreeB():
    conn = sqlite3.connect('final.db')
    cursor = conn.cursor()

    select = "SELECT * FROM PseduoMV;"
    cursor.execute(select)
    rows = cursor.fetchall()

    column_names = [description[0] for description in cursor.description]

    dict_rows = [dict(zip(column_names, row)) for row in rows]

    with open('tweets.json', 'w', encoding='utf-8') as json_file:
        json.dump(dict_rows, json_file, ensure_ascii=False, indent=4)

def partThreeC():
    conn = sqlite3.connect('final.db')
    cursor = conn.cursor()

    select = "SELECT * FROM PseduoMV;"

    df = pd.read_sql(select, conn)

    df.to_csv('tweets.csv', index=False)

finalFunc()