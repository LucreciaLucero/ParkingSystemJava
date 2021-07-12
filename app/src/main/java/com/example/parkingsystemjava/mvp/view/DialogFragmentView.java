package com.example.parkingsystemjava.mvp.view;

import com.example.parkingsystemjava.databinding.DialogFragmentParkingLotsBinding;
import com.example.parkingsystemjava.fragment.DialogFragmentParkingLots;
import com.example.parkingsystemjava.mvp.contract.DialogFragmentContract;
import com.example.parkingsystemjava.mvp.view.base.FragmentView;

public class DialogFragmentView extends FragmentView implements DialogFragmentContract.ViewContract {
    private DialogFragmentParkingLotsBinding binding;

    public DialogFragmentView(DialogFragmentParkingLotsBinding binding, DialogFragmentParkingLots dialogFragmentParkingLots) {
        super(dialogFragmentParkingLots);
        this.binding = binding;
    }

    public String getParkingsAvailable() {
        return binding.inputTextDialogFragmentParkingLots.getText().toString();
    }

    @Override
    public void dismissDialogFragmentParkingLots() {
        DialogFragmentParkingLots dialogFragmentRef = (DialogFragmentParkingLots) getFragment();
        if (dialogFragmentRef != null) {
            dialogFragmentRef.dismiss();
        }
    }
}
