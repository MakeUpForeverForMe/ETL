from lib.MySQLConnect import MySQLConnect

with MySQLConnect() as con:
  con.execute('select * from ETL_STRUCT')
  data = con.fetchall()
  print(data)
