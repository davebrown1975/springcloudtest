package com.tucanoo.spring.guestservices

import org.springframework.data.repository.CrudRepository

interface GuestRepository extends CrudRepository<Guest,Long>{

}