package com.yaniv.flightreservation.flightreservation.repo;

import com.yaniv.flightreservation.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
