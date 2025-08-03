package com.emranhss.project;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectOneApplication {

    public static void main(String[] args) {

        // Load .env file using dotenv-java
//        Dotenv dotenv = Dotenv.configure()
//                .directory("./")
//                .ignoreIfMalformed()
//                .ignoreIfMissing()
//                .load();
//
//        // Set properties so Spring can read them using ${...}
//        dotenv.entries().forEach(entry ->
//                System.setProperty(entry.getKey(), entry.getValue())
//        );

        Dotenv dotenv = Dotenv.load();

        System.setProperty("SMTP_USER", dotenv.get("SMTP_USER"));
        System.setProperty("SMTP_PASS", dotenv.get("SMTP_PASS"));
        System.setProperty("SMTP_PORT", dotenv.get("SMTP_PORT"));


        SpringApplication.run(ProjectOneApplication.class, args);


    }

}
