package com.example.parkingsystemjava.mvp.view;

import androidx.fragment.app.FragmentManager;
import com.example.parkingsystemjava.activity.ReservationActivity;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.fragment.DateTimeReservationDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;
import com.example.parkingsystemjava.utils.ConstantUtils;

public class ReservationView extends ActivityView implements ReservationActivityContract.ViewContract {
    private ActivityReservationBinding binding;

    public ReservationView(ActivityReservationBinding binding, ReservationActivity reservationActivity) {
        super(reservationActivity);
        this.binding = binding;
    }

    @Override
    public void showDateTimeInfo() {
        FragmentManager fragmentManager = getFragmentManager();
        DateTimeReservationDialogFragment datePickerDialogFragment = new DateTimeReservationDialogFragment();
        datePickerDialogFragment.show(fragmentManager, ConstantUtils.DIALOG_FRAGMENT_RESERVATION_TAG);
    }
}
