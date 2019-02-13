# -*- coding: utf-8 -*-
'''
浏览器静态页面浏览工具
'''

from bs4 import BeautifulSoup


class SoupUtil:
    '''
    初始化浏览器静态页面工具
    :param driver 浏览器驱动
    '''

    def __init__(self, driver):
        self.driver = driver

    def get_local_soup_page(self):
        return BeautifulSoup(self.driver.page_source, "html.parser")
