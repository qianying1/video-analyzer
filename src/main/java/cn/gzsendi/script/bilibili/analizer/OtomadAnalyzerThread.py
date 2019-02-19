# -*- coding=utf-8 -*-
'''
鬼畜栏目分析线程
'''
import threading


class OtomadAnalyzerThread(threading.Thread):
    '''
    动画分析工具初始化
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
    数据爬取入口
    '''

    def run(self):
        self.crawl()

    '''
    爬取数据执行者
    '''

    def crawl(self):
        print self.soup.select('body')
