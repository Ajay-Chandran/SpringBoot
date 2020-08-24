package ajay.chandran.boot.springPoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorld {
    @RequestMapping("/")
    public String index(){
        return "Hello Spring world";
    }
}
