package cn.gzsendi.service.bilibili;

import cn.gzsendi.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestServiceTest {

    @Autowired
    private IndexAnalyzer indexAnalyzer;
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void startTest() {
        try {
            indexAnalyzer.index();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}