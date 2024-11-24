package com.almosafer.paymentrules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoAuditing
//@EnableMongoRepositories
public class PaymentRulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentRulesApplication.class, args);
    }

}
