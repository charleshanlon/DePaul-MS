import sqlite3
import json
import urllib.request
import time

def tweetStore():
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

    conn = sqlite3.connect('9tweets.db') # open db conection 
    cursor = conn.cursor()

    cursor.execute(dropTableTweets)
    cursor.execute(dropTableUsers)
    cursor.execute(dropTableGeo)
    cursor.execute(createTableGeo)
    cursor.execute(createTableUsers)
    cursor.execute(createTableTweets)

    tweetData = 'https://dbgroup.cdm.depaul.edu/DSC450/Module7.txt'
    webFD = urllib.request.urlopen(tweetData)
    tweets = webFD.readlines()
    fd = open('errors.txt', 'w+', encoding="utf8")
    #tweets = data.split("         EndOfTweet          ")

    for tweet in tweets:
        currGeo = []
        try:
            tmp = json.loads(tweet.decode('utf8'))

            if tmp['geo'] is not None:
                geoId = str(tmp['geo']['coordinates'][0]) + str(tmp['geo']['coordinates'][1])
                currGeo = [geoId, tmp['geo']['type'], tmp['geo']['coordinates'][0], tmp['geo']['coordinates'][1]]
            else:
                geoId = None
            
            tmpDate = tmp["created_at"].split(' ')
            cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
            currTweet = [cleanDate, tmp["id_str"], tmp['user']['id'], geoId, tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"]]
            currUser = [tmp['user']['id'], tmp['user']['name'], tmp['user']['screen_name'], tmp['user']['description'], tmp['user']['friends_count']]
            #print(currTweet)
            #print(currUser)
            #print(currGeo)
            #print(currGeo)
            #print("\n")
            cursor.execute("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?,?,?)", currTweet)
            cursor.execute("INSERT OR IGNORE INTO Users VALUES(?,?,?,?,?)", currUser)
            if len(currGeo) > 0:
                cursor.execute("INSERT OR IGNORE INTO Geo VALUES(?,?,?,?)", currGeo)

        except ValueError:
            fd.write("Error: " + str(tweet) + "\n")
        #tmp = json.loads(tweet)
        #tmpDate = tmp["created_at"].split(' ')
        #cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
        #currTweet = [cleanDate, tmp["id_str"], tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"] ]

    #1a
    start = time.time()
    query = cursor.execute("SELECT TweetId FROM Tweets WHERE TweetId LIKE '%89%' OR TweetId LIKE '%78%';").fetchall()
    end = time.time()
    print(query)
    print('Query took: ' + str(end - start) + ' seconds')

    #1b
    start = time.time()
    res = []
    for tweet in tweets:
        try:
            tmp = json.loads(tweet.decode('utf8'))
            tweetId = tmp['id_str']
            if '89' in tweetId or '78' in tweetId:
                res.append(tweetId)
        except:
            fd.write("Error: " + str(tweet) + "\n")
    print(res)
    end = time.time()
    print('Query took: ' + str(end - start) + ' seconds')

    #1c
    start = time.time()
    query = cursor.execute("SELECT COUNT(DISTINCT FriendsCount) AS unique_fc FROM Users;").fetchall()
    end = time.time()
    print(query)
    print('Query took: ' + str(end - start) + ' seconds')

    #1d
    start = time.time()
    ufc = []
    for tweet in tweets:
        try:
            tmp = json.loads(tweet.decode('utf8'))
            tweetId = tmp['id_str']
            curr = tmp['user']['friends_count']
            if curr not in ufc:
                ufc.append(curr)
        except:
            fd.write("Error: " + str(tweet) + "\n")
    end = time.time()
    print(len(ufc))
    print('Query took: ' + str(end - start) + ' seconds')

        
    """
    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    test2 = cursor.execute("SELECT COUNT(*) FROM Users;").fetchall()
    test3 = cursor.execute("SELECT COUNT(*) FROM Geo;").fetchall()
    print(test1)
    print(test2)
    print(test3)
    """
    fd.close()

tweetStore()