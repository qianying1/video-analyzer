package cn.gzsendi.task.bilibili;

import cn.gzsendi.service.bilibili.IndexCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 针对b站的数据爬去任务
 */
@Component
@EnableScheduling
public class CrawlerTask {

    @Autowired
    private IndexCrawlService indexCrawlServiceImpl;

    /**
     * 数据爬取任务
     */
    @Scheduled
    public void crawl() {
        indexCrawlServiceImpl
    }
}
