package cn.gzsendi.service.bilibili;

import com.alibaba.fastjson.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class IndexAnalyzer {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试restTemplate进行http请求
     *
     * @throws JSONException
     * @throws IOException
     */
    public Object index() throws JSONException, IOException {
//        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
//        paramMap.add("username", "admin");
//        paramMap.add("password", "123456");

        long start = System.currentTimeMillis();
        //{1} 表示第一个占位符，也可以填写name,但是这是另一个getForEntity重载方法
//        RuiooResponseEntity 为自定义dto
//        try {
////            SslUtils.ignoreSsl();
//            SslUtils.trustAllHttpsCertificates();
//            HostnameVerifier hv = new HostnameVerifier() {
//                public boolean verify(String urlHostName, SSLSession session) {
//                    System.out.println("Warning: URL Host: " + urlHostName + " vs. "
//                            + session.getPeerHost());
//                    return true;
//                }
//            };
//            HttpsURLConnection.setDefaultHostnameVerifier(hv);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        final String url = "https://www.bilibili.com/";
//        HttpHeaders httpHeaders=new HttpHeaders();
//        HttpEntity<String> httpEntity=new HttpEntity<>(null,httpHeaders);
//        httpHeaders.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class, headerMap);
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("耗时：" + cost);
//        JSONObject body = entity.getBody();
        System.out.println("响应体：" + entity);
        return entity;
    }
}