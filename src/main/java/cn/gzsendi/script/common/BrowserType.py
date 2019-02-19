# -*- coding: utf-8 -*-
'''
浏览器类型
'''
import enum


class BrowserType(enum.Enum):

    '''
    谷歌浏览器
    '''
    GHROME = "chrome"
    '''
    火狐浏览器
    '''
    FIREFOX = "firefox"
    '''
    新版IE浏览器
    '''
    EDGE = "edge"
    '''
    旧版ie
    '''
    IE = "ie"
    '''
    欧朋浏览器
    '''
    OPERA = "opera"
