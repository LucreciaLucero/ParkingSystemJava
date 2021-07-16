package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.database.ReservationDataBase;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.ModelContract {
    private int parkingAvailables;

    public void setParkingAvailables(int parkingLots) {
        this.parkingAvailables = parkingLots;
    }

    public int getParkingAvailables() {
        return this.parkingAvailables;
    }

    public int getClearPastReservations() {
        return ReservationDataBase.getInstance().releasePastReservations();
    }
}
