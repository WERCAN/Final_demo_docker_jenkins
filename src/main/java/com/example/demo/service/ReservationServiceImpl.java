package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl() {
    }

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Iterable<Reservation> findAll() {
        Iterable<Reservation> reservations=reservationRepository.findAll();

        return reservations;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Reservation createdReservation=reservationRepository.save(reservation);

        return createdReservation;
    }
}
