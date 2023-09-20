import sqlite3
import json

def tweetStore():
    createTableTweets = """
  CREATE TABLE Tweets
  (
    CreatedOn           VARCHAR2(50),
    TweetId             VARCHAR2(50) NOT NULL,      
    Body                VARCHAR2(200),
    Source              VARCHAR2(200),
    ReplyToUser         VARCHAR2(50),
    ReplyToName         VARCHAR(100),
    ReplyToStatus       VARCHAR(100),
    Retweets            NUMBER(10),
    Contributors        VARCHAR(100),

    CONSTRAINT Tweets_PK
      PRIMARY KEY(TweetId)
  );
  """
    dropTableTweets = "DROP TABLE IF EXISTS Tweets"
    
    

    conn = sqlite3.connect('5tweets.db') # open db conection 
    cursor = conn.cursor()
    fd = open('Module5.txt', 'r', encoding="utf8")
    data = fd.read()
    tweets = data.split("         EndOfTweet          ")

    cursor.execute(dropTableTweets)
    cursor.execute(createTableTweets)

    for tweet in tweets:
        currTweet = []
        tmp = json.loads(tweet)
        tmpDate = tmp["created_at"].split(' ')
        cleanDate = tmpDate[1] + ' ' + tmpDate[2]  + ' ' + tmpDate[5]
        currTweet = [cleanDate, tmp["id_str"], tmp["text"], tmp["source"], tmp["in_reply_to_user_id"], tmp["in_reply_to_screen_name"], tmp["in_reply_to_status_id"], tmp["retweet_count"], tmp["contributors"] ]
        cursor.execute("INSERT OR IGNORE INTO Tweets VALUES(?,?,?,?,?,?,?,?,?)", currTweet)

    test1 = cursor.execute("SELECT COUNT(*) FROM Tweets;").fetchall()
    print(test1)

    
        #print(row)
    fd.close()

tweetStore()