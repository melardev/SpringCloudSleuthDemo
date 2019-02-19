package com.melardev.cloud.zipkinsleuth;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZipkinSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinSleuthApplication.class, args);
    }

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    Sampler getSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
