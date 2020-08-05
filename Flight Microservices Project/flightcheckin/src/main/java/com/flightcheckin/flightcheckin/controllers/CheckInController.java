package com.flightcheckin.flightcheckin.controllers;


import com.flightcheckin.flightcheckin.dto.Reservation;
import com.flightcheckin.flightcheckin.dto.ReservationUpdateRequest;
import com.flightcheckin.flightcheckin.integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient restClient;


    @RequestMapping("/showStartCheckin")
    public String ShowStartCheckin(){

        return "startcheckin";
    }


    @RequestMapping("/startCheckIn")
    public String StartCheckin(@RequestParam("reservationId") Long reservationId , ModelMap modelMap){

        Reservation reservation= restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation",reservation);

        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationID") Long reservationId, @RequestParam("numberOfBags")int numberofBags){
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckIn(true);
        reservationUpdateRequest.setNumberOfBags(numberofBags);
        restClient.updateReservation(new ReservationUpdateRequest());

        return "checkinConfirmation";
    }


}
