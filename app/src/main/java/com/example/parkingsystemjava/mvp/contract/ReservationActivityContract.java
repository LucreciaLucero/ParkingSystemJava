package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import java.util.Calendar;

public interface ReservationActivityContract {
    interface PresenterContract {
        void dateTimePickerButtonStartPressed();

        void dateTimePickerButtonEndPressed();

        void setReservationCalendar(Calendar date, boolean value);

        void buttonSaveReservation();

        void buttonCancelReservation();

        boolean check(Reservation reservation);
    }

    interface ViewContract {
        String getParkingLots();

        String getUserPassword();

        void showDateTimeInfo(boolean isStartDate);

        void dismissActivity();

        void showMessageOfSavedStatement(Reservation reservation);

        void showMessageOfError();

        void showMessageOfOverlapReservation();
    }

    interface ModelContract {
        void setStartDate(Calendar startDate);

        void setEndDate(Calendar endDate);

        void saveReservation();

        Reservation createReservation(String parkingLots, String pass);

        boolean existsOverlap(Reservation reservation);

        boolean isOverlap();
    }
}
