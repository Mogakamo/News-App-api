package com.news.nyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URLEncoder;

@SpringBootApplication
@EnableSwagger2
public class NewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);
    }
}
