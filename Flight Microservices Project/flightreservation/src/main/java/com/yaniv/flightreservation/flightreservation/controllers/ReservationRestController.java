package com.yaniv.flightreservation.flightreservation.controllers;

import com.yaniv.flightreservation.flightreservation.dto.ReservationUpdateRequest;
import com.yaniv.flightreservation.flightreservation.entities.Reservation;
import com.yaniv.flightreservation.flightreservation.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){

     Reservation reservation= reservationRepository.findOne(id);
      return reservation;
    }

    @RequestMapping("/reservations")
    public  Reservation updateReservation(@RequestBody  ReservationUpdateRequest request)
    {
        Reservation reservation= reservationRepository.findOne(request.getId());
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckIn());
        return  reservationRepository.save(reservation);
    }

}
