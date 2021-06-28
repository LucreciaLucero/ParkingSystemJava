package com.example.parkingsystemjava.mvp.contract;

public interface ParkingContract {
    interface PresenterContract {
        void onButtonPressed();

        void setParkingLots(int parkingLots);
    }

    interface ModelContract {
        void setParkingAvailables(int parkingLots);

        int getParkingAvailables();
    }

    interface ViewContract {
        void showMessageOfParkingLots(int parkingsAvailable);

        void showParkingsAvailable(int parkingsAvailable);
    }
}
