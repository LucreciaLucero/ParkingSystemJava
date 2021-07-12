package com.example.parkingsystemjava.ReservationObject;

import java.util.Calendar;

public class Reservation {
    private Calendar startDate;
    private Calendar endDate;
    private String parkingLots;
    private String userPassword;

    public Reservation() {
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public String getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(String parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
