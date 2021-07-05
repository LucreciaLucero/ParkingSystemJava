package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingPresenter implements ParkingContract.PresenterContract {

    private ParkingContract.ModelContract model;
    private ParkingContract.ViewContract view;

    public ParkingPresenter(ParkingContract.ModelContract model, ParkingContract.ViewContract view) {
        this.model = model;
        this.view = view;
    }

    public void onButtonPressed() {
        view.showParkingsAvailable(model.getParkingAvailables());
    }

    @Override
    public void setParkingLots(int parkingLots) {
        model.setParkingAvailables(parkingLots);
        view.showMessageOfParkingLots(model.getParkingAvailables());
    }

    public void onButtonReservationPressed() {
        view.showReservationScreen();
    }
}
