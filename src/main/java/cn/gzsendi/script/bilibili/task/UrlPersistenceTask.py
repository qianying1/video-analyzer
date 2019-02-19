# -*- coding=utf-8 -*-
'''
网络链接地址持久化任务
'''

import threading
import sys
import MySQLdb
from common.CrawUrlQueue import *


class UrlPersistenceTask(threading.Thread):
    '''
    初始化爬取队列链接地址队列持久化任务
    '''

    def __init__(self):
        threading.Thread.__init__(self)
        if CrawUrlQueue.URL_QUEUE is None:
            self.runnable = False

    '''
    持久化任务执行入口，如果是需要进行持久化则进行持久化操作，如果不需要则跳过
    '''

    def run(self):
        while self.runnable:
            self.persistence()

    '''
    进行持久化任务
    '''

    def persistence(self):
        print 'test'
