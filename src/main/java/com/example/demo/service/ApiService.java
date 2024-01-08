// api 를 불러오고 json 을 원하는 형태로 파싱하고 비동기방식으로 전달하기 위해서는 보통 클라이언트에서 함(자바스크립트)
package com.example.demo.service;

import com.example.demo.dto.TourSpotResponse;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class ApiService {

    public static final String API_KEY = "70axhgpopy3z4k5f";
    String API_URL = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=" + API_KEY + "&locale=kr&category=c1";

    /* public : 다른 클래스에서도 이 메서드를 사용할 수 있게 함.
       TourSpotResponse : 메서드가 반환하는 타입. 여기선 TourSpotResponse 라는 클래스를 반환함.
       getTourSpotResponse : 메서드 이름
       throws IOException : 예외를 던짐. 메서드 내에서 I/O 입출력 할때 발생할 예외를 처리한다. */

    // getTourSpotResponse() 메서드 호출하면 api url 읽고, 버퍼리더, 한줄출력 등의 기능들을 거쳐서 , gson 라이브러리를 통해 java 객체로 변환, String으로 보여지게 함

    // 하지만 이 경우 getTourSpotResponse() 메서드 에서는 TourSpotResponse 만 불러옴, 한 메서드당 하나의 DTO 만 불러올 수 있음, 각기 만들고 controller 에서도 각기 불러와야함
    public TourSpotResponse getTourSpotResponse() throws IOException {

        URL url = new URL(API_URL);

        // 받아온 url 변수를 열어줘, 한글 안깨지게, 그리고 그걸 버퍼링 안걸리게 읽어줘, 그 값을 bf 에 넣을게.
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            // StringBuilder : 여러문자열을 효율적으로 합칠때 사용. apiResult : 받아온 api 데이터 저장 객체
            StringBuilder apiResultResponse = new StringBuilder();
            String line;
            // 반복문으로 bf에 저장된 값을 readLine 한줄씩 불러온값을 line 변수에 저장, 그 값이 null 이 아닌 동안 계속 반복, 그 값들을 apiResult 변수에 한줄씩 추가.
            while ((line = bf.readLine()) != null) {
                apiResultResponse.append(line);
            }
            // Gson 라이브러리로 Json 객체를 Java 객체로 변환 혹은 그 반대의 경우도 가능
            Gson gson = new Gson();
            // apiResultResponse 에 저장되어있는 값들을 스트링으로 바꾸고, 그것들을 Tour~ 클래스에 맵핑. Json 문자열을 gson 라이브러리로 자바 객체로 변환
            return gson.fromJson(apiResultResponse.toString(), TourSpotResponse.class);
        }
    }

}
