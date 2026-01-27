package com.syazanie.tapir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing; // <--- Import this

@SpringBootApplication
@EnableJpaAuditing
public class TapirApplication {

    public static void main(String[] args) {
        SpringApplication.run(TapirApplication.class, args);
    }

}