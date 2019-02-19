# -*- coding=utf-8 -*-

from bs4 import BeautifulSoup

from analizer import IndexAnalyzerThread
from common import BrowserType
from common import MysqlUtil
from common import WebBrowser
from common.Properties import *


class BilibiliMain:
    '''
    根据视频类型名称获取视频列表
    '''

    def get_video_of_type(self):
        print 'test'


'''
初始化系统数据库连接池
'''


def db_init():
    properties = Properties.get_properties()
    MysqlUtil.MysqlUtil.init_db_connects(properties['host'], properties['port'], properties['username'],
                                         properties['password'],
                                         properties['db'])


index_url = "http://www.bilibili.com/"

if '__main__' == __name__:
    # 初始化数据库连接池
    db_init()
    # 初始化浏览器工具
    browser = WebBrowser.WebBrowser(r'F://firefox', BrowserType.BrowserType.FIREFOX, index_url)
    print browser.page_url
    try:
        soup = BeautifulSoup(browser.driver.page_source, "html.parser")
    except Exception as e:
        print e
        if browser is not None:
            browser.driver.quit()
        raise e
    # 进行首页数据爬取
    indexThread = IndexAnalyzerThread.IndexAnalyzerThread(1, 'index_crawler', browser.driver, soup,index_url)
    indexThread.start()
