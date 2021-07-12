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
    }

    interface ViewContract {
        String getParkingLots();

        String getUserPassword();

        void showDateTimeInfo(boolean isStartDate);

        void dismissActivity();

        void showMessageOfSavedStatement(Reservation reservation);
    }

    interface ModelContract {
        void setStartDate(Calendar startDate);

        void setEndDate(Calendar endDate);

        void saveReservation(String parkingLots, String pass);

        Reservation getReservation(String parkingLots, String pass);
    }
}
