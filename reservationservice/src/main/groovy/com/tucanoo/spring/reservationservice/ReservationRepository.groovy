package com.tucanoo.spring.reservationservice

import org.springframework.data.repository.CrudRepository

interface ReservationRepository extends CrudRepository<Reservation, Long>{

}