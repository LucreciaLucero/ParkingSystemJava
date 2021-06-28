package com.example.parkingsystemjava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.example.parkingsystemjava.databinding.DialogFragmentParkingLotsBinding;
import com.example.parkingsystemjava.mvp.contract.DialogFragmentContract;
import com.example.parkingsystemjava.mvp.listener.ParkingDialogFragmentListener;
import com.example.parkingsystemjava.mvp.presenter.DialogFragmentPresenter;
import com.example.parkingsystemjava.mvp.view.DialogFragmentView;

public class DialogFragmentParkingLots extends DialogFragment {
    private DialogFragmentParkingLotsBinding binding;
    private DialogFragmentContract.PresenterContract presenter;
    private ParkingDialogFragmentListener customListenerDialogFragment;

    public DialogFragmentParkingLots() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.customListenerDialogFragment = (ParkingDialogFragmentListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DialogFragmentParkingLotsBinding.inflate(getLayoutInflater());
        presenter = new DialogFragmentPresenter(new DialogFragmentView(binding, this));
        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.buttonSaveDialogFragmentParkingSize.setOnClickListener(view -> presenter.onSaveButtonPressed(customListenerDialogFragment));
        binding.buttonCancelDialogFragmentParkingSize.setOnClickListener(view -> presenter.onCancelButtonPressed());
    }
}
