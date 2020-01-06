from lib.MySQLConnect import MySQLConnect
from json import loads
from datetime import datetime

# with MySQLConnect(host='192.168.18.100', passwd='000000') as con:
with MySQLConnect(host='10.83.16.22', passwd='INikGPLun*8v') as con:
  con.execute('select * from STRUCT_BASE')
  datas = con.fetchall()
  print(datas)
  con.execute('select * from STRUCT_ETL')
  datas = con.fetchall()
  print(datas)
  # for data in datas:
  #   print('alias\t', data['alias'])
  #   print('imex\t', data['imex'])
  #   print('type\t', data['type'])
  #   print('hosts\t', data['hosts'])
  #   print('user\t', data['user'])
  #   print('passwd\t', data['passwd'])
  #   print('fromdb\t', data['fromdb'])
  #   print('aimsdb\t', data['aimsdb'])
  #   print('table\t', data['table'])
  #   print('stime\t', datetime.timetuple(data['stime']))
  #   print('ltime\t', data['ltime'])
  #   year_month = None
  #   day_of_month = None
  #   if data['parti'] is not None:
  #     year_month = loads(data['parti'])['year_month']
  #     day_of_month = loads(data['parti'])['day_of_month']
  #   print('year_month\t', year_month)
  #   print('day_of_month\t', day_of_month)
