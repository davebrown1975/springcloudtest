package com.tucanoo.spring.reservationservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class ReservationserviceApplication {

    static void main(String[] args) {
        SpringApplication.run(ReservationserviceApplication, args)
    }

}
