package com.yaniv.flightreservation.flightreservation.repo;

import com.yaniv.flightreservation.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
}


