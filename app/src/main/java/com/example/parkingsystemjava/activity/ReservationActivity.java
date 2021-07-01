package com.example.parkingsystemjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import com.example.parkingsystemjava.mvp.presenter.ReservationPresenter;
import com.example.parkingsystemjava.mvp.view.ReservationView;

public class ReservationActivity extends AppCompatActivity {
    private ActivityReservationBinding binding;
    private ReservationActivityContract.PresenterContract presenter;

    public static Intent newInstance(Context context) {
        return new Intent(context, ReservationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ReservationPresenter(new ReservationView(binding, this));
        setListenerDateTimePicker();
    }

    public void setListenerDateTimePicker() {
        binding.buttonInitialDateTimePickerActivityReservation.setOnClickListener(view -> presenter.dateTimePickerButtonPressed());
        binding.buttonEndDateTimePickerActivityReservation.setOnClickListener(view -> presenter.dateTimePickerButtonPressed());
    }
}
