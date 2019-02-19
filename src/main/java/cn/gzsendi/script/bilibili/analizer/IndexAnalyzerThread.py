# -*- coding: utf-8 -*-
'''
首页分析工具
'''

import threading

import AdvertAnalyzerThread
import AnimationAnalyzerThread
import DanceAnalyzerThread
import DigitAnalyzerThread
import EntertainAnalyzerThread
import FashionAnalyzerThread
import FilmTelevAnalyzerThread
import FolkOperaAnalyzerThread
import GameAnalyzerThread
import LifeAnalyzerThread
import MusicAnalyzerThread
import NationInnovationAnalyzerThread
import OtomadAnalyzerThread
import ScienceTecAnalyzerThread
import VideoHallAnalyzerThread
from common import MysqlUtil
from common import WebBrowser


class IndexAnalyzerThread(threading.Thread):
    '''
    首页分析工具初始化
    :param driver 浏览器驱动
    :param soup 浏览器静态工具
    '''

    DOMAIN = 'https://www.bilibili.com/'

    def __init__(self, thread_id, thread_name, driver, soup, index_page):
        threading.Thread.__init__(self)
        self.thread_id = thread_id
        self.thread_name = thread_name
        self.driver = driver
        self.soup = soup
        self.index_page = index_page

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
        print '*' * 100
        print '=' * 30, u'开始进行b站首页的数据爬取工作', '=' * 30
        print '*' * 100
        # 休眠3秒，等待页面数据加载
        # time.sleep(10)
        # 获取首页body节点的静态页面数据
        try:
            # 进行导航栏数据爬取
            self.crawl_nav_menus()
            # 进行视频数据爬取
            self.crawl_videos()
        finally:
            if self.driver is not None:
                self.driver.quit()

    '''
    进行视频数据爬取
    '''

    def crawl_videos(self):
        recommend_video_module = self.soup.find('div', class_='recommend-module')
        videos = recommend_video_module.find_all('div', class_='home-card')
        video_list = []
        index = 0
        # 处理推荐视频
        for video_div in videos:
            a_href = video_div.find('a')
            print u'视频链接如下：', a_href
            link = IndexAnalyzerThread.DOMAIN + a_href['href']
            title = a_href['title']
            img_src = a_href.find('img', class_='pic')  # 整个img标签
            img_link = img_src['src']  # img图片的远程链接
            img_descs = a_href.find('div', class_='card-mark')
            video_title = img_descs.find('p', class_='title').text
            video_author = img_descs.find('p', class_='author').text
            video_play = img_descs.find('p', class_='play').text
            video_list.insert(index, {'link': link, 'title': title, 'img_html': img_src, 'img_link': 'http:'+img_link,
                                      'author': video_author, 'play': video_play, 'video_title': video_title})
            index = index + 1
            print 'video title: ', video_title, ' video author: ', video_author, ' video play: ', video_play
        # 处理推广视频
        storey_videos = self.soup.find('div', class_='storey-box').find_all('div', class_='spread-module')
        for video in storey_videos:
            a_link = video.find('a')
            link = 'https:' + a_link['href']
            img_div = a_link.find('div', class_='pic')
            video_title = a_link.find('p', class_='t')['title']
            img_link = 'http:' + img_div.find('img')['src']
            duration = img_div.find('span', class_='dur').text
            danmu_ps = img_div.find('div', class_='danmu-module').find('p', class_='dm')
            danmus = []
            i = 0
            if danmu_ps is not None:
                for danmu in danmu_ps:
                    danmus.insert(i, danmu.text)
            video_list.insert(index, {'link': link, 'title': video_title, 'img_html': img_div.find('img'),
                                      'img_link': img_link,
                                      'author': None, 'play': None, 'video_title': video_title, 'duration': duration,
                                      'danmus': danmus})

        print video_list
        return video_list

    '''
    爬取头部导航栏数据
    '''

    def crawl_nav_menus(self):
        # index_link = self.driver.find_element_by_class_name('home').find_element_by_tag_name('a').get_property('href')
        nav_menus = self.soup.find('ul', class_='nav-menu')
        print u'导航栏链接：', nav_menus
        for menu in nav_menus.find_all('li'):
            a_text = str(menu.find('a'))
            animation_thread = None
            name_div = menu.find('a').find('div', class_='nav-name')
            parent_type = None
            if name_div is None:
                name_div = menu.find('a').find('span')
                parent_div = menu.parent.parent.find('a').find('div', class_='nav-name')
                if parent_div is None:
                    parent_div = menu.parent.parent.parent.find('a').find('span')
                parent_type = parent_div.text
                if parent_type == u'首页':
                    parent_type = None
            type_name = name_div.text
            self.persistence_nav(type_name, parent_type)
            if a_text.__contains__('首页'):
                print u'首页', a_text
                continue
            elif a_text.__contains__('动画'):
                print u'动画', a_text
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                animation_thread = AnimationAnalyzerThread.AnimationAnalyzerThread(2, 'animation_thread', self.driver,
                                                                                   soup)
                animation_thread.start()
                continue
            elif a_text.__contains__('番剧'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                folk_opera_thread = FolkOperaAnalyzerThread.FolkOperaAnalyzerThread(3, 'folk_opera_thread', self.driver,
                                                                                    soup)
                folk_opera_thread.start()
                continue
            elif a_text.__contains__('国创'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                nation_inno_thread = NationInnovationAnalyzerThread.NationInnovationAnalyzerThread(4,
                                                                                                   'nation_inno_thread',
                                                                                                   self.driver, soup)
                nation_inno_thread.start()
                continue
            elif a_text.__contains__('音乐'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                music_thread = MusicAnalyzerThread.MusicAnalyzerThread(5, 'music_thread', self.driver, soup)
                music_thread.start()
                continue
            elif a_text.__contains__('舞蹈'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                dance_thread = DanceAnalyzerThread.DanceAnalyzerThread(6, 'dance_thread', self.driver, soup)
                dance_thread.start()
                continue
            elif a_text.__contains__('游戏'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                game_thread = GameAnalyzerThread.GameAnalyzerThread(7, 'game_thread', self.driver, soup)
                game_thread.start()
                continue
            elif a_text.__contains__('科技'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                science_thread = ScienceTecAnalyzerThread.ScienceTecAnalyzerThread(8, 'science_thread', self.driver,
                                                                                   soup)
                science_thread.start()
                continue
            elif a_text.__contains__('数码'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                digit_thread = DigitAnalyzerThread.DigitAnalyzerThread(9, 'digit_thread', self.driver, soup)
                digit_thread.start()
                continue
            elif a_text.__contains__('生活'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                life_thread = LifeAnalyzerThread.LifeAnalyzerThread(10, 'life_thread', self.driver, soup)
                life_thread.start()
                continue
            elif a_text.__contains__('鬼畜'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                otomad_thread = OtomadAnalyzerThread.OtomadAnalyzerThread(11, 'otomad_thread', self.driver, soup)
                otomad_thread.start()
                continue
            elif a_text.__contains__('时尚'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                fashion_thread = FashionAnalyzerThread.FashionAnalyzerThread(12, 'fashion_thread', self.driver, soup)
                fashion_thread.start()
                continue
            elif a_text.__contains__('广告'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                advert_thread = AdvertAnalyzerThread.AdvertAnalyzerThread(13, 'advert_thread', self.driver, soup)
                advert_thread.start()
                continue
            elif a_text.__contains__('娱乐'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                entertain_thread = EntertainAnalyzerThread.EntertainAnalyzerThread(14, 'entertain_thread', self.driver,
                                                                                   soup)
                entertain_thread.start()
                continue
            elif a_text.__contains__('影视'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                film_tel_thread = FilmTelevAnalyzerThread.FilmTelevAnalyzerThread(15, 'film_tel_thread', self.driver,
                                                                                  soup)
                film_tel_thread.start()
                continue
            elif a_text.__contains__('放映厅'):
                self.driver.get('https:' + menu.find('a')['href'])
                soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
                video_hall_thread = VideoHallAnalyzerThread.VideoHallAnalyzerThread(16, 'video_hall_thread',
                                                                                    self.driver,
                                                                                    soup)
                video_hall_thread.start()
                continue
            # parent_menu = menu.parent
            # if parent_menu['class'] == [u'sub-nav']:
            #     continue
            # target = 'https:' + menu.find('a')['href']
            # print target
            # self.driver.get(target)
            # soup = WebBrowser.WebBrowser.get_special_page_soup(self.driver)
            # print soup.find('body')
            # break

    '''
    持久化导航栏标题数据信息
    '''

    def persistence_nav(self, type_name, parent_type):
        if type_name is None:
            return False
        db_conn = MysqlUtil.MysqlUtil.get_db_conn()
        db_cur = db_conn.cursor()
        sql = "select count(id) from video_type where name='" + type_name + "' and source_='bilibili'"
        db_cur.execute(sql)
        select_res = db_cur.fetchone()  # 返回结果为字典
        if select_res[0] >= 1:
            return False
        sql = "insert into video_type(name,parent_id,source_,insert_time) values('" + type_name + "',"
        if parent_type is not None and parent_type != '':
            sql1 = "select id from video_type where name='" + parent_type + "' and source_='bilibili'"
            db_cur.execute(sql1)
            res1 = db_cur.fetchone()
            sql = sql + str(res1[0])
        else:
            sql = sql + "Null"
        sql = sql + ",'bilibili',NOW())"
        db_cur.execute(sql)
        db_conn.commit()
        res = db_cur.fetchone()
        print res
        return True
