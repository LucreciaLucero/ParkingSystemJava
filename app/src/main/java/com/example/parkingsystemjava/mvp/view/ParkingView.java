package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.activity.ReservationActivity;
import com.example.parkingsystemjava.databinding.ActivityMainBinding;
import com.example.parkingsystemjava.fragment.DialogFragmentParkingLots;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;
import com.example.parkingsystemjava.utils.ConstantUtils;

public class ParkingView extends ActivityView implements ParkingContract.ViewContract {

    private final ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showParkingsAvailable(int parkingsAvailable) {
        FragmentManager fragmentManager = getFragmentManager();
        DialogFragmentParkingLots editNameDialogFragment = new DialogFragmentParkingLots();
        editNameDialogFragment.show(fragmentManager, ConstantUtils.DIALOG_FRAGMENT_TAG);
    }

    @Override
    public void showMessageOfParkingLots(int parkingsAvailable) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context,
                    context.getString(R.string.toast_main_parking_size,
                            parkingsAvailable),
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void showReservationScreen() {
        Context context = getContext();
        Activity activity = getActivity();
        if (context != null && activity != null) {
            activity.startActivity(ReservationActivity.newInstance(context));
        }
    }
}
