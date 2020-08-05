package com.flightcheckin.flightcheckin.integration;

import com.flightcheckin.flightcheckin.dto.Reservation;
import com.flightcheckin.flightcheckin.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient{

    private static final String Reservation_REST_URL = "http://localhost:8080/flightreservation/reservation/";


    @Override
    public Reservation findReservation(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate
                .getForObject(Reservation_REST_URL +id,Reservation.class);

        return reservation;
    }


    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {

        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate
                .postForObject(Reservation_REST_URL ,request,Reservation.class);

        return reservation;
    }
}
