package com.tucanoo.spring.guestservices

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class GuestservicesApplication {

    static void main(String[] args) {
        SpringApplication.run(GuestservicesApplication, args)
    }

}
