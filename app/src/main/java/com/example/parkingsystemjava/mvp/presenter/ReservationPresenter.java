package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;

public class ReservationPresenter implements ReservationActivityContract.PresenterContract {
    private ReservationActivityContract.ViewContract view;

    public ReservationPresenter(ReservationActivityContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public void dateTimePickerButtonPressed() {
        view.showDateTimeInfo();
    }
}
