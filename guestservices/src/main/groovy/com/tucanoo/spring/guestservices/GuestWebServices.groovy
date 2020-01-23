package com.tucanoo.spring.guestservices

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/guests")
class GuestWebServices {
    @Autowired
    GuestRepository guestRepository

    @GetMapping
    Iterable<Guest> getAllGuests() {
        this.guestRepository.findAll()
    }

    @GetMapping("/{id}")
    Guest getGuest(@PathVariable("id") long id) {
        this.guestRepository.findById(id).get()
    }
}
