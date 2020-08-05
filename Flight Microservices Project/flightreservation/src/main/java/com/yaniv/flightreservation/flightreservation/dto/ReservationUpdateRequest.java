package com.yaniv.flightreservation.flightreservation.dto;

public class ReservationUpdateRequest {


    private Long Id;
    private Boolean CheckIn;
    private int numberOfBags;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Boolean getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(Boolean checkIn) {
        CheckIn = checkIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }
}
