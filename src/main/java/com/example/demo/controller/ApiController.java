/* Api 호출 및 데이터 처리 수행
 객체지향 프로그래밍의 메서드 Like PHP 의 함수, but 함수는 프로그램 어디서나 호출 가능이지만, 객체지향에서는 메서드가 클래스에 속한다.
 메서드 역할 : 클래스 내부에서 정의되어, 클래스의 인스턴스에 특정한 동작을 수행하거나 값을 반환하는 역할
 메서드 정의 : public class MyClass {
            public void myMethod() {};
            public int add(int a, int b) { return a + b; }
            }
            // (클래스)(인스턴스객체) = new(클래스)();
 메서드 호출 : MyClass myObject = new MyClass();
            // 인스턴스 객체에 myMethod 메서드의 값을 넣는다.
            myObject.myMethod();
            // 인스턴스 객체에 add(3,5) 값을 넣는다. 그 값을 다시 int result에 넣는다.
            int result = myObject.add(3,5);
            sout(result); */

package com.example.demo.controller;

import com.example.demo.dto.TourSpotResponse;
import com.example.demo.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
// Controller : 웹 요청을 처리함
public class ApiController {
    //ApiService 타입의 apiService 필드선언, 클래스 내에서 변경 불가 final 상수처리
    private final ApiService apiService;

    // 의존성주입 : 클래스가 자신이 필요로 하는 객체를 직접 지정하지 않고, 외부의 객체를 받아와서 사용.
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/tour")
    public String getTourSpotResponse(Model model) {
        try {
            // ApiService를 통해 TourSpotResponse를 가져옴
            TourSpotResponse response = apiService.getTourSpotResponse();

            // 가져온 데이터를 모델에 담아서 뷰로 전달
            model.addAttribute("tourSpotList", response);

            // "tour"는 Thymeleaf 템플릿 파일의 이름 (resources/templates/tour.html)
            return "tour";
        } catch (IOException e) {
            // 에러 발생 시 에러 페이지로 이동
            return "error";
        }
    }

    @GetMapping("/detailPage")
    public String detailPage(Model model) {
        model.addAttribute("message", "hi");
        return "detailPage";
    }
}

