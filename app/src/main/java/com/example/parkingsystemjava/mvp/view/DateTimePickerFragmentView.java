package com.example.parkingsystemjava.mvp.view;

import com.example.parkingsystemjava.databinding.DialogFragmentDateTimeReservationBinding;
import com.example.parkingsystemjava.fragment.DateTimeReservationDialogFragment;
import com.example.parkingsystemjava.listener.DateTimePickerListener;
import com.example.parkingsystemjava.mvp.contract.DateTimePickerContract;
import com.example.parkingsystemjava.mvp.view.base.FragmentView;
import java.util.Calendar;

public class DateTimePickerFragmentView extends FragmentView implements DateTimePickerContract.ViewContract {
    private DialogFragmentDateTimeReservationBinding binding;

    public DateTimePickerFragmentView(DialogFragmentDateTimeReservationBinding binding, DateTimeReservationDialogFragment dateTimeReservationDialogFragment) {
        super(dateTimeReservationDialogFragment);
        this.binding = binding;
    }

    @Override
    public void saveReservationFields(DateTimePickerListener dateTimePickerListener, boolean isStartDate) {
        Calendar calendar = Calendar.getInstance();
        int day = binding.datePickerDialogFragment.getDayOfMonth();
        int month = binding.datePickerDialogFragment.getMonth();
        int year = binding.datePickerDialogFragment.getYear();
        int hour = binding.timePickerDialogFragment.getHour();
        int minute = binding.timePickerDialogFragment.getMinute();
        calendar.set(year, month, day, hour, minute);
        dateTimePickerListener.listenerSetDateTimePicker(calendar, isStartDate);
    }

    @Override
    public void dismissDialogFragment() {
        DateTimeReservationDialogFragment dialogFragmentRef = (DateTimeReservationDialogFragment) getFragment();
        if (dialogFragmentRef != null) {
            dialogFragmentRef.dismiss();
        }
    }
}
