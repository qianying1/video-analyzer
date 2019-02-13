# -*- coding: utf-8 -*-
'''
网络爬虫之用户名密码及验证码登陆：爬取知乎网站
'''
import sys
import time

# import BeautifulSoup
from bs4 import BeautifulSoup
from selenium import webdriver


# import MySQLdb


class BilibiliSpider:
    def __init__(self, url):
        self.url = url
        self.hello()

    def get_headers(self):
        headers = {
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
            'Upgrade-Insecure-Requests': '1'
        }
        return headers

    def hello(self):
        print "*" * 100
        print u"正在爬去B站内容！"
        print "*" * 100

    def crawl(self, i=1):
        # 创建一个driver用于打开网页，记得找到brew安装的chromedriver的位置，在创建driver的时候指定这个位置
        # options = webdriver.ChromeOptions()
        # options.binary_location = r'../geckodriver.exe'
        driver = webdriver.Firefox(r'F://firefox')
        driver.get(self.url)
        soup = BeautifulSoup(driver.page_source, "html.parser")
        bodys = soup.select('body')

        index = 1
        for body in bodys:
            # print u'第', index, u'个body节点的内容为：', body.encode("gbk")
            index = index + 1
            headerCs = body.select('#chief_recommend')
            for headerC in headerCs:
                print headerC.encode('utf-8')
                hrefs = headerC.select('a')
                for href in hrefs:
                    print href.encode('utf-8')
                    src = href['href']
                    print src.encode('utf-8')
                    driver.get(src)
                    page = BeautifulSoup(driver.page_source, "html.parser")
                    print page.encode('utf-8')
                    # href.click
                    time.sleep(60)
            # try:
            #     driver.find_element_by_xpath("//a[contains(text(),'下一页')]").click()  # selenium的xpath用法，找到包含“下一页”的a标签去点击
            # except Exception as e:
            #     print "exception!", e
            # page = page + 1
            time.sleep(2)  # 睡2秒让网页加载完再去读它的html代码
        driver.quit()
    # html = requests.get(self.url, headers=self.get_headers())
    # print '获取网页内容：',requests.get('https://www.bilibili.com/',headers=self.get_headers()),' end'
    # print html
    # print html.text


if __name__ == '__main__':
    reload(sys)
    sys.setdefaultencoding('utf8')  # 设置系统默认字符编码
    url = "http://www.bilibili.com/"
    bilibili = BilibiliSpider(url)
    bilibili.crawl()
