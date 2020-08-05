package com.yaniv.flightreservation.flightreservation.services;

import com.yaniv.flightreservation.flightreservation.dto.ReservationRequest;
import com.yaniv.flightreservation.flightreservation.entities.Reservation;
import org.springframework.stereotype.Service;


public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);



}