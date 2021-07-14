package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.listener.DateTimePickerListener;

public interface DateTimePickerContract {
    interface PresenterContract {
        void onSaveButtonPressed(DateTimePickerListener dateTimePickerListener, boolean isStartDate);

        void onCancelButtonPressed();
    }

    interface ViewContract {
        void saveReservationFields(DateTimePickerListener dateTimePickerListener, boolean isStartDate);

        void dismissDialogFragment();
    }
}
