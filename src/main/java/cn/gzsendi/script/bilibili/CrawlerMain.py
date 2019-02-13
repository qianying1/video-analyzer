# -*- coding=utf-8 -*-
'''
针对b站的爬虫主入口
'''
import sys

class CrawlerMain:


if __name__ == '__main__':
    reload(sys)
    sys.setdefaultencoding('utf8')  # 设置系统默认字符编码
    url = "http://www.bilibili.com/"
    bilibili = CrawlerMain(url)
    bilibili.crawl()