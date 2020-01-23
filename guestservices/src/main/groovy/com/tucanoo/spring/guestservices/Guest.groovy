package com.tucanoo.spring.guestservices

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="GUEST")
class Guest {
    @Id
    @Column(name="GUEST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    @Column(name = "FIRST_NAME")
    String firstName
    @Column(name = "LAST_NAME")
    String lastName
    @Column(name = "EMAIL_ADDRESS")
    String emailAddress
    @Column(name = "ADDRESS")
    String address
    @Column(name = "COUNTRY")
    String country
    @Column(name = "STATE")
    String state
    @Column(name = "PHONE_NUMBER")
    String phoneNumber
}
