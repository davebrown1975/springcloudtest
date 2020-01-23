package com.tucanoo.spring.reservationservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reservations")
class ReservationWebServices {
    @Autowired
    ReservationRepository reservationRepository

    @GetMapping
    Iterable<Reservation> getAllReservations() {
        this.reservationRepository.findAll()
    }

    @GetMapping("/{id}")
    Reservation getReservation(@PathVariable("id") long id) {
        this.reservationRepository.findById(id).get()
    }
}
