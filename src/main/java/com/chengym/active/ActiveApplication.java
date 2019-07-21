package com.chengym.active;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@MapperScan("com.chengym.active.**.dao")
public class ActiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveApplication.class, args);
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_THREADLOCAL);
    }

}
