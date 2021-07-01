package com.example.parkingsystemjava.mvp.contract;

public interface ParkingContract {
    interface PresenterContract {
        void onButtonPressed();

        void onButtonReservationPressed();

        void setParkingLots(int parkingLots);
    }

    interface ModelContract {
        void setParkingAvailables(int parkingLots);

        int getParkingAvailables();
    }

    interface ViewContract {
        void showParkingsAvailable(int parkingsAvailable);

        void showReservationScreen();

        void showMessageOfParkingLots(int parkingsAvailable);
    }
}
