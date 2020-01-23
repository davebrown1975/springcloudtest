package com.tucanoo.spring.roomservices

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rooms")
class RoomWebServices {
    @Autowired
    RoomRepository RoomRepository

    @GetMapping
    Iterable<Room> getAllRooms() {
        this.RoomRepository.findAll()
    }

    @GetMapping("/{id}")
    Room getRoom(@PathVariable("id") long id) {
        this.RoomRepository.findById(id).get()
    }
}
