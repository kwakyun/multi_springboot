package org.example.kakao_map_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class KakaoMapService {
    @Value("${KAKAO_API_URL}")
    private String KAKAO_API_URL;

    @Value("${KAKAO_API_KEY}")
    private String KAKAO_API_KEY;

    public String searchAddress(String query) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders(); // 헤더 설정
        httpHeaders.set("Authorization", KAKAO_API_KEY);
        URI uri = UriComponentsBuilder.fromUriString(KAKAO_API_URL).queryParam("query", query).build()
                .encode(StandardCharsets.UTF_8).toUri();
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders); //엔티티로 만들기
        //GetForObject()메소드로는 헤더를 정의할 수 없어서 exchange()메소드 사용
        ResponseEntity<Map> result = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Map.class);

        // API 요청 및 응답 처리
        try {
            return result.getBody().toString();
//            return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "API 요청 실패";
        }
    }
}