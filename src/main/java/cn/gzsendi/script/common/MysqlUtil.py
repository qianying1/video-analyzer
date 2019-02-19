# -!- coding=utf-8 -*-
'''
数据库操作工具
'''
import Queue
import threading

import MySQLdb
import pymysql
from DBUtils.PooledDB import PooledDB

from Properties import *


class MysqlUtil:
    '''
    数据库连接池
    '''
    DB_POOL = Queue.Queue()
    db_lock = threading.RLock()
    host = ''
    port = ''
    username = ''
    password = ''
    db = ''
    count = -1
    charset = 'utf8'

    def __init__(self):
        print 'MysqlUtil init begin ...... '
        global DB_POOL
        if DB_POOL is None:
            DB_POOL = Queue.Queue()

    '''
    初始化数据库连接
    :param count 初始化数据库连接的数量
    :param host 数据库连接地址
    :param username 数据库连接用户名
    :param password 数据库连接密码
    :param db 连接的数据库名称
    :return: 
     '''

    @staticmethod
    def init_db_connects(host, port, username, password, db, count=-1, charset='utf8'):
        try:
            MysqlUtil.db_lock.acquire()
            MysqlUtil.host = host
            MysqlUtil.port = port
            MysqlUtil.username = username
            MysqlUtil.password = password
            MysqlUtil.db = db
            MysqlUtil.count = count
            MysqlUtil.charset = charset
        finally:
            MysqlUtil.db_lock.release()
        # 默认初始化数量为10个数据库连接
        if count <= 0:
            count = 10
        if host is None or username is None or db is None:
            return
        # 打开数据库连接
        if password is None:
            password = ''
        MysqlUtil.DB_POOL = PooledDB(MySQLdb, count, host=str(host), user=username, passwd=password, db=str(db),
                                     port=int(port),
                                     charset=charset)  # 5为连接池里的最少连接数

    '''
    获取数据库连接后的句柄
    '''

    @staticmethod
    def get_db_cur():
        if MysqlUtil.DB_POOL is None:
            MysqlUtil.init_db_connects(MysqlUtil.host, MysqlUtil.port, MysqlUtil.username, MysqlUtil.password,
                                       MysqlUtil.db,
                                       MysqlUtil.count, MysqlUtil.charset)
            return MysqlUtil.DB_POOL.connection().cursor(cursor=pymysql.cursors.DictCursor)
        return MysqlUtil.DB_POOL.connection().cursor()

    '''
    获取数据库连接
    '''

    @staticmethod
    def get_db_conn():
        if MysqlUtil.DB_POOL is None:
            MysqlUtil.init_db_connects(MysqlUtil.host, MysqlUtil.port, MysqlUtil.username, MysqlUtil.password,
                                       MysqlUtil.db,
                                       MysqlUtil.count, MysqlUtil.charset)
            return MysqlUtil.DB_POOL.connection().cursor(cursor=pymysql.cursors.DictCursor)
        return MysqlUtil.DB_POOL.connection()

    '''
    关闭当前db数据库连接
    :param db 需要进行释放的数据库连接
    '''

    # def close_db(self, db):
    #     if db is not None:
    #         try:
    #             db.close()
    #         except MySQLdb.MySQLError as e:
    #             print e
    #             return False
    #         return True
    #     return False


if __name__ == '__main__':
    properties = Properties.get_properties()
    print properties
    MysqlUtil.init_db_connects(properties['host'], properties['port'], properties['username'], properties['password'],
                               properties['db'])
    db_cur = MysqlUtil.get_db_cur()
    sql = "select * from user_"
    db_cur.execute(sql)
    select_res = db_cur.fetchall()  # 返回结果为字典
    # print 'op_select ', select_res
    for user in select_res:
        print u'用户名: ', user[0]
        print u'昵称： ', user[1]
        print u'密码：', user[2]
        print u'emal: ', user[5]
    db_cur = MysqlUtil.get_db_cur()
    sql = "select * from device"
    db_cur.execute(sql)
    select_res = db_cur.fetchall()  # 返回结果为字典
    # print 'op_select ', select_res
    print u'设备\n\n\n\n'
    for device in select_res:
        print u'用户名: ', device[0]
        print u'昵称： ', device[1]
        print u'密码：', device[2]
        print u'emal: ', device[5]
