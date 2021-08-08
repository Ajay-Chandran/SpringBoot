package ajay.chandran.boot.springPoc.controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class HelloWorld {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello Spring world";
    }
    @RequestMapping("/ajay")
    public String helloAjay(){
        return "Hello Spring Ajay";
    }
    @GetMapping("/hello")
    public String helloName(@RequestParam(name="name", required = false, defaultValue = "Its me") String name)
    {
        return "Hello " + name;
    }
    @GetMapping("/helloName/{name}")
    public String hello0(@PathVariable("name") String name)
    {
        return "Hello " + name;
    }
}
