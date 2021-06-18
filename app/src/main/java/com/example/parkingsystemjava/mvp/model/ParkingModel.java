package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.ModelContract {

    private int parkingAvailables = 0;

    public void setParkingAvailables() {
        this.parkingAvailables = 10;
    }

    public int getParkingAvailables() {
        return this.parkingAvailables;
    }
}
