import mysql.connector
from mysql.connector import Error
from datetime import datetime
import pandas as pd



try:
    connection = mysql.connector.connect(host='localhost', database='sport', user='root', password='root',port=3306)
    cursor = connection.cursor()
    
except Error as e:
    print("Error while connecting to MySQL", e)

cursor.execute("SELECT timestamp FROM log")
result = cursor.fetchall() 
timeseries=[datetime.fromtimestamp(i[0]).strftime("%d-%m-%Y") for i in result]
date = pd.Series(timeseries)
df = date.value_counts(sort=False).rename_axis('datetime').to_frame('requests')
df.to_csv('Stats.csv', sep=',')
