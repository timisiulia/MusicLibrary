package com.example.musiclibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication@Validated@EnableWebMvc
//@EntityScan(basePackages = "com.example.musiclibrary.models")
//@EnableJpaRepositories(basePackages = "com.example.musiclibrary.repositories")
public class MusicLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicLibraryApplication.class, args);
    }

}
