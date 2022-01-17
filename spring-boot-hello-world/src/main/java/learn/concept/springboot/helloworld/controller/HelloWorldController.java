package learn.concept.springboot.helloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class HelloWorldController {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello Spring world";
    }
    @RequestMapping("/welcome")
    public String helloWorldWelcome(){
        return "Learning Spring: Welcome";
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
