package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.database.ReservationDataBase;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import java.util.Calendar;

public class ReservationModel implements ReservationActivityContract.ModelContract {
    private final Reservation reservation = new Reservation();
    private final ReservationDataBase database;

    public ReservationModel(ReservationDataBase database) {
        this.database = database;
    }

    @Override
    public void saveReservation(String parkingLots, String userPassword) {
        this.reservation.setParkingLots(parkingLots);
        this.reservation.setUserPassword(userPassword);
        database.addValues(reservation);
    }

    @Override
    public Reservation getReservation(String parkingLots, String pass) {
        return this.database.getReservation(parkingLots, pass);
    }

    @Override
    public void setStartDate(Calendar startDate) {
        this.reservation.setStartDate(startDate);
    }

    @Override
    public void setEndDate(Calendar endDate) {
        this.reservation.setEndDate(endDate);
    }
}
