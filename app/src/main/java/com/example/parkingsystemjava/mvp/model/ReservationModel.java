package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.database.ReservationDataBase;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import java.util.Calendar;
import java.util.List;

public class ReservationModel implements ReservationActivityContract.ModelContract {
    private final Reservation reservation = new Reservation();
    private final ReservationDataBase database;
    private boolean overlap = false;

    public ReservationModel(ReservationDataBase database) {
        this.database = database;
    }

    @Override
    public void saveReservation() {
        if (!existsOverlap(reservation)) {
            database.addValues(reservation);
        }
    }

    public Reservation createReservation(String parkingLots, String userPassword) {
        if (reservation.getStartDate() != null && reservation.getEndDate() != null &&
                !parkingLots.equals("") && !userPassword.equals("")) {
            this.reservation.setParkingLots(parkingLots);
            this.reservation.setUserPassword(userPassword);
            return this.reservation;
        }
        return null;
    }

    @Override
    public void setStartDate(Calendar startDate) {
        this.reservation.setStartDate(startDate);
    }

    @Override
    public void setEndDate(Calendar endDate) {
        this.reservation.setEndDate(endDate);
    }

    public boolean existsOverlap(Reservation reservation) {
        if (reservation != null) {
            List<Reservation> reservationList = database.getReservation(reservation.getParkingLots());
            if (reservationList != null) {
                for (Reservation reservationSearched : reservationList) {
                    if (reservationSearched.getEndDate().after(reservation.getStartDate())) {
                        overlap = true;
                        return true;
                    }
                }
            }
        }
        overlap = false;
        return false;
    }

    public boolean isOverlap() {
        return overlap;
    }
}
