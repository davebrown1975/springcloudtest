package com.tucanoo.spring.roomreservationservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class RoomreservationserviceApplication {

    static void main(String[] args) {
        SpringApplication.run(RoomreservationserviceApplication, args)
    }

}
