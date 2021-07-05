package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.listener.ParkingDialogFragmentListener;

public interface DialogFragmentContract {
    interface PresenterContract {
        void onSaveButtonPressed(ParkingDialogFragmentListener customListenerDialogFragment);

        void onCancelButtonPressed();
    }

    interface ViewContract {
        String getParkingsAvailable();

        void dismissDialogFragmentParkingLots();
    }
}
