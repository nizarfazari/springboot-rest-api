package javaguides.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// We use @Controller to make java class as a Spring MVC
// @Controller
// @ResponseBody annotation tells a contoller that the object return is automatically serialized into JSON and passed back into the HTTPResponse object
// @ResponseBody

// this annotation is combination of @Controller and @ResponseBody
@RestController

public class HelloWorldController {

    // annotation to map HTTP GET into specific handler method
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
