package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import com.example.parkingsystemjava.utils.ConstantUtils;
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
        Reservation reservation = model.createReservation(view.getParkingLots(), view.getUserPassword());
        model.existsOverlap(reservation);
        if (!model.isOverlap()) {
            if (check(reservation)) {
                model.saveReservation();
                view.showMessageOfSavedStatement(reservation);
                view.dismissActivity();
            } else {
                view.showMessageOfError();
            }
        } else {
            view.showMessageOfOverlapReservation();
        }
    }

    @Override
    public void buttonCancelReservation() {
        view.dismissActivity();
    }

    @Override
    public boolean check(Reservation reservation) {
        if (reservation != null) {
            if (reservation.getStartDate() != null || reservation.getEndDate() != null ||
                    !reservation.getParkingLots().equals(ConstantUtils.EMPTY_STRING) ||
                    !reservation.getUserPassword().equals(ConstantUtils.EMPTY_STRING)) {
                return true;
            }
        }
        return false;
    }
}
