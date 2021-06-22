package com.example.parkingsystemjava.mvp.contract;

public interface ParkingContract {
    interface PresenterContract {
        void onButtonPressed();
    }

    interface ModelContract {
        void setParkingAvailables();

        int getParkingAvailables();
    }

    interface ViewContract {
        void showParkingsAvailable(int parkingsAvailable);
    }
}
