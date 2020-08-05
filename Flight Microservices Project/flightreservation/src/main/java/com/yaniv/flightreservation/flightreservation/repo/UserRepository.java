package com.yaniv.flightreservation.flightreservation.repo;

import com.yaniv.flightreservation.flightreservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findbyEmail(String email);
}
