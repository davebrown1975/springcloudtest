package com.tucanoo.spring.roomreservationservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("reservationservice")
interface ReservationClient {
    @GetMapping("/reservations")
    List<Reservation> getReservations(@RequestParam(name="date", required = false) Date date)

    @GetMapping("/reservations/{id}")
    Reservation getReservation(@PathVariable("id")long id)
}