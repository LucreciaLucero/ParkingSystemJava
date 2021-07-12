package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import java.util.Calendar;

public class ReservationPresenter implements ReservationActivityContract.PresenterContract {
    private ReservationActivityContract.ViewContract view;
    private ReservationActivityContract.ModelContract model;

    public ReservationPresenter(ReservationActivityContract.ViewContract view, ReservationActivityContract.ModelContract model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void dateTimePickerButtonStartPressed() {
        view.showDateTimeInfo(true);
    }

    @Override
    public void dateTimePickerButtonEndPressed() {
        view.showDateTimeInfo(false);
    }

    @Override
    public void setReservationCalendar(Calendar date, boolean isStartDate) {
        if (isStartDate) {
            model.setStartDate(date);
        } else {
            model.setEndDate(date);
        }
    }

    @Override
    public void buttonSaveReservation() {
        model.saveReservation(view.getParkingLots(), view.getUserPassword());
        Reservation reservation = model.getReservation(view.getParkingLots(), view.getUserPassword());
        view.showMessageOfSavedStatement(reservation);
        view.dismissActivity();
    }

    @Override
    public void buttonCancelReservation() {
        view.dismissActivity();
    }
}
