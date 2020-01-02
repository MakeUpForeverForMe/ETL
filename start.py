from lib.MySQLConnect import MySQLConnect
from json import loads
from datetime import datetime

print()
with MySQLConnect() as con:
  con.execute('select * from ETL_STRUCT')
  datas = con.fetchall()
  for data in datas:
    print('alias\t', data['alias'])
    print('imex\t', data['imex'])
    print('type\t', data['type'])
    print('hosts\t', data['hosts'])
    print('user\t', data['user'])
    print('passwd\t', data['passwd'])
    print('fromdb\t', data['fromdb'])
    print('aimsdb\t', data['aimsdb'])
    print('table\t', data['table'])
    print('stime\t', datetime.timetuple(data['stime']))
    print('ltime\t', data['ltime'])
    parti = None
    if data['parti'] is not None:
      parti = loads(data['parti'])
    print('parti\t', parti)
