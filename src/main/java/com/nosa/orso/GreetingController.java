package com.nosa.orso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }
}
