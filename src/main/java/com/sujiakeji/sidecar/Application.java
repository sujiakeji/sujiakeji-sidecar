package com.sujiakeji.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSidecar
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}