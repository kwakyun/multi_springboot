package org.example.boot17_openapi_travel.travel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Service
public class PublicDataService {

    @Value("${public.api.url}")
    private String apiUrl;

    @Value("${public.api.serviceKey}")
    private String serviceKey;

    public String getImageUrl(String title) {
        log.info("getImageUrl()....keyword:{}",title);
        String keyword = "";
        try {
            keyword = URLEncoder.encode(title,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        log.info(apiUrl);
        log.info(serviceKey);
        log.info(keyword);
        String str_url = apiUrl + "&serviceKey=" + serviceKey+ "&keyword=" + keyword;
        log.info(str_url); //요청url생성완료

        //java.io 삼종세트로 REST정보 읽어오기.
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        StringBuilder sb = new StringBuilder();//br.readLine() 담는 객체
        try {
            //요청에 필요한 객체 java.net.URL + java.net.HttpURLConnection 를 사용.
            URL url = new URL(str_url);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");

            is = urlConnection.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            urlConnection.disconnect();//사용후 연결끊기
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(br!=null){
                try { br.close(); } catch (IOException e) {}
            }
            if(isr!=null){
                try { isr.close(); } catch (IOException e) {}
            }
            if(is!=null){
                try { is.close(); } catch (IOException e) {}
            }
        }//end finally...

        log.info(sb.toString());

        //오늘의 미션1 : json결과 문자열에서 이미지경로만 추출해서 리턴해주기.

        //return parseImageUrl(sb.toString());// 파싱방법 1
        return parseImageUrl2(sb.toString()); //파싱방법 2
    }//end getImageUrl().....

    private String parseImageUrl2(String jsonString) {
        //Jacson라이브러리(스프링부트에 내장되어있음)를 사용하여 JSON파싱
        ObjectMapper objectMapper = new ObjectMapper();
        String imageUrl = "";
        try {
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode response = rootNode.path("response");
            //JsonNode header = response.path("header");
            JsonNode body = response.path("body");
            JsonNode items = body.path("items").path("item");
            log.info(items.toString());
            log.info("{}",items.isArray());
            log.info("{}",items.get(0).path("galWebImageUrl").asText());
            imageUrl = items.get(0).path("galWebImageUrl").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return imageUrl;
    }

    private String parseImageUrl(String jsonString) {
        //Jacson라이브러리(스프링부트에 내장되어있음)를 사용하여 JSON파싱
        ObjectMapper objectMapper = new ObjectMapper();
        RootObject rootObject = null;

        try {
            rootObject = objectMapper.readValue(jsonString,RootObject.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info(rootObject.toString());
        log.info(rootObject.getResponse().getBody().getItems().getItem().get(0).get("galWebImageUrl"));

        return rootObject.getResponse().getBody().getItems().getItem().get(0).get("galWebImageUrl");
    }


}//end class