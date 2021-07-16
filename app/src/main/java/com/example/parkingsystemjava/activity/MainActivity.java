package com.example.parkingsystemjava.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.databinding.ActivityMainBinding;
import com.example.parkingsystemjava.listener.ParkingDialogFragmentListener;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.model.ParkingModel;
import com.example.parkingsystemjava.mvp.presenter.ParkingPresenter;
import com.example.parkingsystemjava.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity implements ParkingDialogFragmentListener {
    private ActivityMainBinding binding;
    private ParkingContract.PresenterContract presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ParkingPresenter(new ParkingModel(), new ParkingView(this, binding));
        setListeners();
    }

    private void setListeners() {
        binding.buttonMainParkingSize.setOnClickListener(view -> presenter.onButtonPressed());
        binding.buttonMainAddNewReservation.setOnClickListener(view -> presenter.onButtonReservationPressed());
        binding.buttonMainReleasePastReservations.setOnClickListener(view -> presenter.onButtonReleaseReservationsPressed());
    }

    @Override
    public void listenerOnClick(int parkingLots) {
        presenter.setParkingLots(parkingLots);
    }
}
