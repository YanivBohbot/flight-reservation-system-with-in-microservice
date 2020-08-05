package com.flightcheckin.flightcheckin.integration;

import com.flightcheckin.flightcheckin.dto.Reservation;
import com.flightcheckin.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

public Reservation findReservation(Long id);
public Reservation updateReservation(ReservationUpdateRequest request);



}
