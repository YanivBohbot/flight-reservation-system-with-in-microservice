package com.yaniv.flightreservation.flightreservation.services;

import com.yaniv.flightreservation.flightreservation.dto.ReservationRequest;
import com.yaniv.flightreservation.flightreservation.entities.Flight;
import com.yaniv.flightreservation.flightreservation.entities.Passenger;
import com.yaniv.flightreservation.flightreservation.entities.Reservation;
import com.yaniv.flightreservation.flightreservation.repo.FlightRepository;
import com.yaniv.flightreservation.flightreservation.repo.PassengerRepository;
import com.yaniv.flightreservation.flightreservation.repo.ReservationRepository;
import com.yaniv.flightreservation.flightreservation.utilities.Email;
import com.yaniv.flightreservation.flightreservation.utilities.PDFGENERATOR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationImpl implements  ReservationService{

    //we inject the repository to find the flight with the crud operation
    @Autowired
    FlightRepository flightRepository;

    //we inject the repository to save the passenger that we are going to create in the repos and DB
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGENERATOR pdfgenerator;


    @Autowired
    Email email;




    @Override
    public Reservation bookFlight(ReservationRequest request) {

        //make payment

        //search the flight of the request by the user
        Long flightId = request.getFlightId();
        //use the repository the find the flight with the flight id
        Flight flight = flightRepository.findOne(flightId);

        //we create a passenger in the database
        Passenger passenger = new Passenger();
        passenger.setFirstname(request.getPassengerFirstName());
        passenger.setLastname(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());

        //save the passenger in the repo and db
        Passenger savedPassenger=  passengerRepository.save(passenger);

        //create a reservation instance to set the Flight ,the passenger that did the reservation and the chekin
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        //save the reservation in db and get the instance
       Reservation savedReservation = reservationRepository.save(reservation);

        String  filePath ="C:\\Users\\user\\reservation"+savedReservation.getId()+"pdf";
        pdfgenerator.generateItenary(savedReservation,filePath);
        email.sendItnerary(passenger.getEmail(),filePath);

        return savedReservation;
    }
}
