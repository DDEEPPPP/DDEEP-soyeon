// 현 파일은 스프링부트의 시작점 main , 여기서 프로젝트가 시작됨.
// 메인 메서드에서는 보통 SpringApp~ 와 같이 스프링부트를 시작하겠다는 메서드만 들어감. 나머지는 서비스나 컨트롤러 같은곳에서 각기 실행
// DemoApplication > ApiService > ApiController > list

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DemoApplication {

    //main 메서드 역할 : 스프링부트 DemoApplication 이제 시작할게.
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
