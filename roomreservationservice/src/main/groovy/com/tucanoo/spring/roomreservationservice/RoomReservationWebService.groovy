package com.tucanoo.spring.roomreservationservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import java.lang.reflect.ParameterizedType

@RestController
@RequestMapping("/room-reservations")
class RoomReservationWebService {
    @Autowired
    RoomClient roomClient

    @GetMapping
    List<RoomReservation> getRoomReservations(){

        List<RoomReservation> reservations = []

        roomClient.getAllRooms().each {room ->
            println room.dump()
            reservations << new RoomReservation(
                    roomId: room.roomId,
                    roomNumber: room.roomNumber,
                    roomName: room.roomName
            )
        }

        return reservations
    }

//    List<Room> getAllRooms(){
//        ResponseEntity<List<Room>> roomResponse =
//                restTemplate.exchange("http://ROOMSERVICES/rooms",
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<Room>>(){})
//
//        return roomResponse.body
//    }
}
