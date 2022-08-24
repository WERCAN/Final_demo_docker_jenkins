package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController() {
    }

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservation", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Reservation>> getAllReservations(){
        System.out.println("Inside reservationController \n getMapping");

        Iterable<Reservation> reservations=reservationService.findAll();
        return ResponseEntity.ok(reservations);
    }

    @PostMapping(value = "/reservation",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        System.out.println("Posting Reservation");

        Reservation createdReservation=reservationService.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }
}
