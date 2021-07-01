package com.example.parkingsystemjava.mvp.contract;

public interface ReservationActivityContract {
    interface PresenterContract {
        void dateTimePickerButtonPressed();
    }

    interface ViewContract {
        void showDateTimeInfo();
    }
}
