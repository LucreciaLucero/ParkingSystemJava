package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.model.ParkingModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ParkingPresenterTest {
    private ParkingContract.ModelContract model;
    private ParkingContract.PresenterContract presenter;
    @Mock
    private ParkingContract.ViewContract view;
    private static final int PARKING_LOTS = 10;
    private static final int ZERO = 0;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        model = new ParkingModel();
        presenter = new ParkingPresenter(model, view);
    }

    @Test
    public void onButtonPressedSetParkingLotsTest() {
        presenter.onButtonPressed();

        verify(view).showParkingsAvailable(model.getParkingAvailables());
    }

    @Test
    public void onSetParkingLotsTest() {
        presenter.setParkingLots(PARKING_LOTS);

        assertEquals(PARKING_LOTS, model.getParkingAvailables());
        verify(view).showMessageOfParkingLots(model.getParkingAvailables());
    }

    @Test
    public void onButtonReleaseReservationsPressedTest() {
        presenter.onButtonReleaseReservationsPressed();

        assertEquals(ZERO, model.getClearPastReservations());
        verify(view).showMessageOfClearReservations(ZERO);
    }

    @Test
    public void onButtonReservationPressedTest() {
        presenter.onButtonReservationPressed();

        verify(view).showReservationScreen();
    }
}
