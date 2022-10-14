package br.com.alexandria.biblioteca.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helthCheck")
public class HealthCheck {

    @GetMapping
    public String getStatus(){
        return "api status: ok";
    }

}
