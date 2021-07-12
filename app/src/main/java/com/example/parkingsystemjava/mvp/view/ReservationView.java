package com.example.parkingsystemjava.mvp.view;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.activity.ReservationActivity;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.fragment.DateTimeReservationDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;
import com.example.parkingsystemjava.utils.ConstantUtils;
import com.example.parkingsystemjava.utils.DateUtils;

public class ReservationView extends ActivityView implements ReservationActivityContract.ViewContract {
    private final ActivityReservationBinding binding;

    public ReservationView(ActivityReservationBinding binding, ReservationActivity reservationActivity) {
        super(reservationActivity);
        this.binding = binding;
    }

    @Override
    public String getParkingLots() {
        return binding.editTextParkingPlaceActivityReservation.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return binding.editTextActivityReservationCodePlace.getText().toString();
    }

    @Override
    public void showDateTimeInfo(boolean isStartDate) {
        FragmentManager fragmentManager = getFragmentManager();
        DateTimeReservationDialogFragment datePickerDialogFragment = DateTimeReservationDialogFragment.newInstance(isStartDate);
        if (fragmentManager != null) {
            datePickerDialogFragment.show(fragmentManager, ConstantUtils.DIALOG_FRAGMENT_RESERVATION_TAG);
        }
    }

    @Override
    public void showMessageOfSavedStatement(Reservation reservation) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context,
                    context.getString(R.string.toast_saved_reservation_activity,
                            DateUtils.formatDateToString(reservation.getStartDate()),
                            DateUtils.formatDateToString(reservation.getEndDate()),
                            reservation.getParkingLots(),
                            reservation.getUserPassword()),
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void dismissActivity() {
        ReservationActivity reservationActivityRef = (ReservationActivity) getActivity();
        if (reservationActivityRef != null) {
            reservationActivityRef.finish();
        }
    }
}
