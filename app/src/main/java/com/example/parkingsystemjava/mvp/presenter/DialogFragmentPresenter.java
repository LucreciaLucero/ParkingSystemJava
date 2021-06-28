package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.mvp.contract.DialogFragmentContract;
import com.example.parkingsystemjava.mvp.listener.ParkingDialogFragmentListener;

public class DialogFragmentPresenter implements DialogFragmentContract.PresenterContract {
    private DialogFragmentContract.ViewContract view;

    public DialogFragmentPresenter(DialogFragmentContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public void onSaveButtonPressed(ParkingDialogFragmentListener customListenerDialogFragment) {
        String spaces = view.getParkingsAvailable();
        if (!spaces.isEmpty()) {
            Integer numberSpaces = Integer.valueOf(spaces);
            customListenerDialogFragment.listenerOnClick(numberSpaces);
        }
        view.dismissDialogFragmentParkingLots();
    }

    @Override
    public void onCancelButtonPressed() {
        view.dismissDialogFragmentParkingLots();
    }
}
