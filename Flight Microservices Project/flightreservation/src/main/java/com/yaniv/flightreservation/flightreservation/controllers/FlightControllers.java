package com.yaniv.flightreservation.flightreservation.controllers;

import com.yaniv.flightreservation.flightreservation.entities.Flight;
import com.yaniv.flightreservation.flightreservation.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightControllers {

    //injecting the flight repository to find a flight in the Db
    @Autowired
    FlightRepository flightRepository;

    //the function receive params to find the flight
@RequestMapping("findFlight")
    public String  findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                               @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyy") Date departmentDate,
                               ModelMap modelMap){

    //get the list of flight in the db with the params
    List<Flight> flights = flightRepository.findFlights(from,to,departmentDate);

    modelMap.addAttribute("flights",flights);
        return  "DisplayFlight";
    }
}
