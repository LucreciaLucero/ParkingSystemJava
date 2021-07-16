package com.example.parkingsystemjava.mvp.contract;

public interface ParkingContract {
    interface PresenterContract {
        void onButtonPressed();

        void onButtonReservationPressed();

        void setParkingLots(int parkingLots);

        void onButtonReleaseReservationsPressed();
    }

    interface ModelContract {
        void setParkingAvailables(int parkingLots);

        int getParkingAvailables();

        int getClearPastReservations();
    }

    interface ViewContract {
        void showParkingsAvailable(int parkingsAvailable);

        void showReservationScreen();

        void showMessageOfParkingLots(int parkingsAvailable);

        void showMessageOfClearReservations(int reservationsClear);
    }
}
