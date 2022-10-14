package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello를 들어오면 이 메소드를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // viewResolver가 resources/templates에서 화면을 찾아서 처리한다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP 응답의 Body 부분에 직접 return 데이터를 넣어주겠다 (viewResolve에게 주지 않는다.)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 실제로 소스보기 하면 이 한줄만 나온다.
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체를 반환하면 기본으로 JSON으로 반환 (HttpMessageConverter - JsonConverter, StringConverter)
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello { // static 클래스 -> 클래스 안에서 클래스를 쓸 수 있다.
        private String name;

        // 자바 bean 규약 (Getter, Setter)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}