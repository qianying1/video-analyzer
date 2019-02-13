# -*- coding: utf-8 -*-
'''
首页分析工具
'''

import threading


class IndexAnalyzerThread(threading.Thread):
    '''
    首页分析工具初始化
    :param driver 浏览器驱动
    :param soup 浏览器静态工具
    '''

    def __init__(self, thread_id, thread_name, driver, soup):
        threading.Thread.__init__(self)
        self.thread_id = thread_id
        self.thread_name = thread_name
        self.driver = driver
        self.soup = soup

    '''
    开始进行数据爬取分析
    '''

    def run(self):
        self.crawl()

    '''
    进行首页静态页面爬取解释
    '''

    def crawl(self):
        if self.driver is None or self.soup is None:
            return
        # 获取首页body节点的静态页面数据
        page_bodys = self.soup.select("body")
