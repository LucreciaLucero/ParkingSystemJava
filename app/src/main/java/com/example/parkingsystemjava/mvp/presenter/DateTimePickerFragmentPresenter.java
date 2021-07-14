package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.DateTimePickerListener;
import com.example.parkingsystemjava.mvp.contract.DateTimePickerContract;

public class DateTimePickerFragmentPresenter implements DateTimePickerContract.PresenterContract {
    private DateTimePickerContract.ViewContract view;

    public DateTimePickerFragmentPresenter(DateTimePickerContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public void onSaveButtonPressed(DateTimePickerListener dateTimePickerListener, boolean isStartDate) {
        view.saveReservationFields(dateTimePickerListener, isStartDate);

        view.dismissDialogFragment();
    }

    @Override
    public void onCancelButtonPressed() {
        view.dismissDialogFragment();
    }
}
