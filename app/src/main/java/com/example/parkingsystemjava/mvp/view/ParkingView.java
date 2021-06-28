package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystemjava.DialogFragmentParkingLots;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.databinding.ActivityMainBinding;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.ViewContract {

    private final ActivityMainBinding binding;
    private final String DIALOG_FRAGMENT_TAG = "dialog_fragment_parking_lots";

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showParkingsAvailable(int parkingsAvailable) {
        FragmentManager fragmentManager = getFragmentManager();
        DialogFragmentParkingLots editNameDialogFragment = new DialogFragmentParkingLots();
        editNameDialogFragment.show(fragmentManager, DIALOG_FRAGMENT_TAG);
    }

    public void showMessageOfParkingLots(int parkingsAvailable) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.toast_main_parking_size, parkingsAvailable), Toast.LENGTH_SHORT).show();
        }
    }
}
