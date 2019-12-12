package com.test.api.gateway.soul.soul;

import org.dromara.soul.client.springmvc.configuration.SoulSpringMvcAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(SoulSpringMvcAutoConfiguration.class)
public class SoulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoulApplication.class, args);
    }

}
