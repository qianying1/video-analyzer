# -*- coding: utf-8 -*-
'''
浏览器实例
'''

import json
import sys

from selenium import webdriver

import BrowserType

sys.path.append("../../exceptions")
sys.path.append("..")
from exceptions import *


class WebBrowser:
    """
    浏览器初始化
    :param page_url 初始化浏览器是给出的第一个页面的地址
    """

    def __init__(self, browser_location, browser_type, page_url, params=None):
        self.init_headers(self)
        self.init_local_driver(self, browser_location, browser_type, page_url)
        self.page_url = page_url
        try:
            json.loads(params, encoding="utf-8")
        except NotJsonFormatError as e:
            raise e
        self.params = params
        # self.driver = webdriver.Firefox(r'F://firefox')

    '''
    初始化请求头参数
    '''

    def init_headers(self, obj):
        obj.headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/65.0",
            'Accept': 'text/html,application/xhtml+xm…ml;q=0.9,image/webp,*/*;q=0.8',
            'Accept-Encoding': 'gzip, deflate, br',
            'Cache-Control': 'max-age=0',
            'Cookie': '_uuid=A05C1660-C56A-F792-0FBF-…5482193372422; fts=1548220757',
            'Connection': 'keep-alive',
            'Accept-Language': 'zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2',
            'Connection': 'keep-alive',
            'Host': 's1.hdslb.com',
            'Referer': '_uuid=A05C1660-C56A-F792-0FBF-…5482193372422; fts=1548220757',
            'Upgrade-Insecure-Requests': '1'}

    '''
    初始化浏览器对象
    :param browser_location 浏览器安装的位置
    :param browser_type 浏览器的类型
    :param page_url 初始化浏览器的首页
    :param params 初始化首页时需要传递的参数
    '''

    def __init__(self, browser_location, browser_type, page_url, **params):
        self.init_headers(self)
        self.init_local_driver(self, browser_location, browser_type, page_url)
        if params.items().__len__() >= 1:
            self.params = params
        self.page_url = page_url

    '''
    初始化当前对象的浏览器驱动
    :param browser_location 本地浏览器驱动位置
    :param browser_type 本地浏览器驱动类型
    :param index_page 浏览器打开的第一个页面http地址
    '''

    def init_local_driver(self, obj, browser_location, browser_type, index_page):
        if browser_type is BrowserType and browser_location is not None and browser_location.strip() != '':
            if browser_type == BrowserType['CHROME']:
                obj.driver = webdriver.Chrome(browser_location)
            elif browser_type == BrowserType['FIREFOX']:
                obj.driver = webdriver.Firefox(browser_location)
            elif browser_type == BrowserType['EDGE']:
                obj.driver = webdriver.Edge(browser_location)
            elif browser_type == BrowserType['IE']:
                obj.driver = webdriver.Ie(browser_location)
            elif browser_type == BrowserType['OPERA']:
                obj.driver = webdriver.Opera(browser_location)
            else:
                obj.driver = webdriver.Safari(browser_location)
            if self.driver is not None and index_page is not None and index_page.strip() != '':
                self.driver.get(index_page)

    '''
    设置请求头中的referer访问者地址参数值
    :param referer 访问地址
    '''

    def set_referer(self, referer):
        if (referer is not None) and referer.strip() != '':
            self.headers['Referer'] = referer

    '''
    设置cookie值
    '''

    def set_cookie(self, cookies):
        if cookies is not None:
            try:
                json.loads(cookies, encoding="utf-8")
            except NotJsonFormatParamsError as nje:
                raise nje
            cs = json.load(cookies, encoding="utf-8")
            cooks = ''
            for cookie in cs:
                cooks = cooks + cookie + "=" + cs[cookie] + ";"
            self.headers['Cookie'] = cooks

    '''
    获取当前对象的本地浏览器驱动
    :param page_url 浏览器打开的新的目标页面
    '''

    def get_local_driver(self, page_url=None):
        if self.driver is None:
            return None
        if page_url is not None:
            self.driver.get(page_url)
        return self.driver
