package com.example.parkingsystemjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.databinding.ActivityMainBinding;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.model.ParkingModel;
import com.example.parkingsystemjava.mvp.presenter.ParkingPresenter;
import com.example.parkingsystemjava.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity {
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
    }
}
