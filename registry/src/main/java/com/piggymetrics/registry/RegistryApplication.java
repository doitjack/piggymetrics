package com.piggymetrics.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.msg.BaseResponse;


@SpringBootApplication
@EnableEurekaServer
   
public class RegistryApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(RegistryApplication.class, args);
	}
	
	
}
