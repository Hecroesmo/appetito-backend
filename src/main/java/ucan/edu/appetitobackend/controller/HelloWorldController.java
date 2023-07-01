package ucan.edu.appetitobackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello!, World...";
    }

    @GetMapping("/dev")
    @ResponseStatus(HttpStatus.OK)
    public String welcome() {
        return "Welcome to dev container";
    }
}
