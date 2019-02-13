# -*- coding=utf-8 -*-
'''
爬取的网络连接队列
'''
import Queue


class CrawUrlQueue:
    '''
    网络地址链接队列
    '''
    URL_QUEUE = Queue.Queue()
    '''
    连接地址队列初始化
    '''

    def __init__(self):
        global URL_QUEUE
        if URL_QUEUE is None:
            URL_QUEUE = Queue.Queue()

    '''
    获取网络地址
    '''

    def get_url(self):
        global URL_QUEUE
        if URL_QUEUE is not None and not URL_QUEUE.empty():
            URL_QUEUE.get()

    '''
    向地址队列中加入网络地址
    :param url 网络连接地址
    '''

    def put_url(self, url):
        global URL_QUEUE
        if URL_QUEUE is None:
            URL_QUEUE = Queue.Queue()
        if url is not None and url.strip() != '':
            URL_QUEUE.put(url)
