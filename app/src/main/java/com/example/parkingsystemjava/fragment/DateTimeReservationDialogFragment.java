package com.example.parkingsystemjava.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.example.parkingsystemjava.databinding.DialogFragmentDateTimeReservationBinding;

public class DateTimeReservationDialogFragment extends DialogFragment {

    public static DateTimeReservationDialogFragment newInstance() {
        return new DateTimeReservationDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        DialogFragmentDateTimeReservationBinding binding = DialogFragmentDateTimeReservationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}
