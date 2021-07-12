package com.example.parkingsystemjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.database.ReservationDataBase;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.listener.DateTimePickerListener;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import com.example.parkingsystemjava.mvp.model.ReservationModel;
import com.example.parkingsystemjava.mvp.presenter.ReservationPresenter;
import com.example.parkingsystemjava.mvp.view.ReservationView;
import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity implements DateTimePickerListener {
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

        presenter = new ReservationPresenter(new ReservationView(binding, this), new ReservationModel(ReservationDataBase.getInstance()));
        setListenerDateTimePicker();
    }

    public void setListenerDateTimePicker() {
        binding.buttonInitialDateTimePickerActivityReservation.setOnClickListener(view -> presenter.dateTimePickerButtonStartPressed());
        binding.buttonEndDateTimePickerActivityReservation.setOnClickListener(view -> presenter.dateTimePickerButtonEndPressed());
        binding.buttonSaveActivityReservation.setOnClickListener(view -> presenter.buttonSaveReservation());
        binding.buttonCancelActivityReservation.setOnClickListener(view -> presenter.buttonCancelReservation());
    }

    @Override
    public void listenerSetDateTimePicker(Calendar date, boolean isStartDate) {
        presenter.setReservationCalendar(date, isStartDate);
    }
}
