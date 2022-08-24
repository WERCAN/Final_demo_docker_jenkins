package com.example.demo.service;

import com.example.demo.model.Reservation;

public interface ReservationService {
    public Iterable<Reservation> findAll();
    public Reservation createReservation(Reservation reservation);
}
