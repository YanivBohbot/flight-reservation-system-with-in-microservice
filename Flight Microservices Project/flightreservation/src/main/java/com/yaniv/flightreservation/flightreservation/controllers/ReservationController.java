package com.yaniv.flightreservation.flightreservation.controllers;

import com.yaniv.flightreservation.flightreservation.dto.ReservationRequest;
import com.yaniv.flightreservation.flightreservation.entities.Flight;
import com.yaniv.flightreservation.flightreservation.entities.Reservation;
import com.yaniv.flightreservation.flightreservation.repo.FlightRepository;
import com.yaniv.flightreservation.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    //we inject the repo of flight for find the flight with the id
    @Autowired
    FlightRepository flightRepository;

    //we inject the service of reservtion to book a flight with the client request
    @Autowired
    ReservationService reservationService;

    @RequestMapping("/ShowcompleteReservation")
    public String ShowcompleteReservation(@RequestParam("flightId") Long flightId , ModelMap modelMap )
    {
        //we find the flight that have the id in the request
        Flight flight = flightRepository.findOne(flightId);
        modelMap.addAttribute("flight",flight);
            return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request,ModelMap modelMap){

        //call the function of bookflligght form the service => send the request and get back instance of reservation
      Reservation reservation=  reservationService.bookFlight(request);
      modelMap.addAttribute("msg","Resevation created succesfully and id is "+reservation.getId());

        return "reservation Confirmed";
    }
}
