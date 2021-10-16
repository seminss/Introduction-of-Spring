package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //localhost8080 으로 들어오면 딱 이게 호출됨
    public String home(){
        return "home";//templates에서 home.html 찾기
    }
}
