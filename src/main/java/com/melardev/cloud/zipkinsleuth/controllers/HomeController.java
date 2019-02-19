package com.melardev.cloud.zipkinsleuth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    int port;

    @GetMapping("/get")
    String get() {
        if (port != 8084) {
            int targetPort = port + 1;
            ResponseEntity<String> ex = restTemplate.exchange("http://localhost:" + targetPort + "/get", HttpMethod.GET
                    , null, new ParameterizedTypeReference<String>() {
                    });
            return (String) ex.getBody();
        } else
            return "Last one reached";
    }
}
