package com.tucanoo.spring.roomreservationservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("roomservices")
interface RoomClient {
    @GetMapping("/rooms")
    List<Room> getAllRooms()

    @GetMapping("/rooms/{id}")
    Room getRoom(@PathVariable("id")long id)
}