package com.example.parkingsystemjava.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.example.parkingsystemjava.databinding.DialogFragmentDateTimeReservationBinding;
import com.example.parkingsystemjava.listener.DateTimePickerListener;
import com.example.parkingsystemjava.mvp.contract.DateTimePickerContract;
import com.example.parkingsystemjava.mvp.presenter.DateTimePickerFragmentPresenter;
import com.example.parkingsystemjava.mvp.view.DateTimePickerFragmentView;
import com.example.parkingsystemjava.utils.ConstantUtils;

public class DateTimeReservationDialogFragment extends DialogFragment {
    private DialogFragmentDateTimeReservationBinding binding;
    private DateTimePickerContract.PresenterContract presenter;
    private DateTimePickerListener dateTimePickerListener;

    public static DateTimeReservationDialogFragment newInstance(boolean isStartDate) {
        DateTimeReservationDialogFragment dateTimeReservationDialogFragment= new DateTimeReservationDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ConstantUtils.TAG_BOOLEAN_VALUE_BUTTON_SAVE_START_DATE,isStartDate);
        dateTimeReservationDialogFragment.setArguments(bundle);
        return dateTimeReservationDialogFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.dateTimePickerListener = (DateTimePickerListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DialogFragmentDateTimeReservationBinding.inflate(getLayoutInflater());
        presenter = new DateTimePickerFragmentPresenter(new DateTimePickerFragmentView(binding, this));
        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.buttonSaveDialogFragmentParkingSize.setOnClickListener(view -> presenter.onSaveButtonPressed(dateTimePickerListener,getArguments().getBoolean(ConstantUtils.TAG_BOOLEAN_VALUE_BUTTON_SAVE_START_DATE)));
        binding.buttonCancelDialogFragmentParkingSize.setOnClickListener(view -> presenter.onCancelButtonPressed());
    }
}
