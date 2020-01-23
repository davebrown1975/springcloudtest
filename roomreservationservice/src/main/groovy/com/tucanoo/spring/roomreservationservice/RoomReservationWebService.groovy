package com.tucanoo.spring.roomreservationservice

import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import java.lang.reflect.ParameterizedType
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/room-reservations")
class RoomReservationWebService {
    @Autowired
    RoomClient roomClient

    @Autowired
    ReservationClient reservationClient

    @Autowired
    GuestClient guestClient

    @GetMapping
    List<RoomReservation> getRoomReservations(@RequestParam(name="date", required = false) String dateParam){

        Date date = new Date()

        try {
            if (dateParam)
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateParam)
        } catch (Exception ex) {}

        Map<Long , RoomReservation> reservations = [:]

        roomClient.getAllRooms().each {room ->
            reservations.put room.roomId, new RoomReservation(
                    roomId: room.roomId,
                    roomNumber: room.roomNumber,
                    roomName: room.roomName
            )
        }
        reservationClient.getReservations(new java.sql.Date(date.time)).each {reservation ->
            RoomReservation roomReservation = reservations.get(reservation.roomId)
            roomReservation.date = date
            Guest guestDetails = guestClient.getGuest(reservation.guestId)
            BeanUtils.copyProperties(guestDetails, roomReservation)
        }

        return reservations.values().toList()
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
