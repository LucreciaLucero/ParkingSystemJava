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
        model.setParkingAvailables();
        view.showParkingsAvailable(model.getParkingAvailables());
    }
}
