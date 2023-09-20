import sqlite3
import json
import urllib.request

def tweetStore():
    createTableTweets = """
  CREATE TABLE Tweets
  (
    CreatedOn           VARCHAR2(50),
    TweetId             VARCHAR2(50) NOT NULL,
    UserId              NUMBER(50) NOT NULL,
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
      REFERENCES User(Id)
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
    dropTableTweets = "DROP TABLE IF EXISTS Tweets"
    dropTableUsers = "DROP TABLE IF EXISTS Users"

    
    
    

    conn = sqlite3.connect('7tweets.db') # open db conection 
    cursor = conn.cursor()

    cursor.execute(dropTableTweets)
    cursor.execute(dropTableUsers)
    cursor.execute(createTableUsers)
    cursor.execute(createTableTweets)

    tweetData = 'https://dbgroup.cdm.depaul.edu/DSC450/Module7.txt'
    webFD = urllib.request.urlopen(tweetData)
    tweets = webFD.readlines()
    fd = open('errors.txt', 'w+', encoding="utf8")
    #tweets = data.split("         EndOfTweet          ")

    for tweet in tweets:
        try:
            tmp = json.loads(tweet.decode('utf8'))
            tmpDate = tmp["created_at"].split(' ')
            cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
            currTweet = [cleanDate, tmp["id_str"], tmp['user']['id'], tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"]]
            currUser = [tmp['user']['id'], tmp['user']['name'], tmp['user']['screen_name'], tmp['user']['description'], tmp['user']['friends_count']]
            print(currTweet)
            print(currUser)
            print("\n")
            cursor.execute("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?,?)", currTweet)
            cursor.execute("INSERT OR IGNORE INTO Users VALUES(?,?,?,?,?)", currUser)
        except ValueError:
            fd.write("Error: " + str(tweet) + "\n")
        #tmp = json.loads(tweet)
        #tmpDate = tmp["created_at"].split(' ')
        #cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
        #currTweet = [cleanDate, tmp["id_str"], tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"] ]
        

    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    test2 = cursor.execute("SELECT COUNT(*) FROM Users;").fetchall()
    print(test1)
    print(test2)
    

    
        #print(row)
    fd.close()

tweetStore()