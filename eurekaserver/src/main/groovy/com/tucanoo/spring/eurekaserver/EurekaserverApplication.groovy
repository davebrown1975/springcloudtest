package com.tucanoo.spring.eurekaserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurekaserverApplication {

    static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication, args)
    }

}
