package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;




//@RestController
//public class HelloController {
//    @RequestMapping(value = '/', method = RequestMethod.GET)
//    public String hello(){
//        return "hello word";
//    }
//}
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}





