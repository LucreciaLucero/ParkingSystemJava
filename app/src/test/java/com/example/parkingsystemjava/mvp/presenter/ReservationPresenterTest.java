package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.database.ReservationDataBase;
import com.example.parkingsystemjava.mvp.contract.ReservationActivityContract;
import com.example.parkingsystemjava.mvp.model.ReservationModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationPresenterTest {
    private ReservationActivityContract.PresenterContract presenter;
    private ReservationActivityContract.ModelContract model;
    @Mock
    private ReservationActivityContract.ViewContract view;
    @Mock
    private Reservation reservation;
    private ReservationDataBase dataBase;

    private static final int DAY_START = 4;
    private static final int DAY_END = 14;
    private static final int DAY_START_OVERLAP = 6;
    private static final int DAY_END_OVERLAP = 17;
    private static final int MONTH = 10;
    private static final int YEAR = 2019;
    private static final int HOUR = 18;
    private static final int MINUTE = 15;
    private static final int ZERO = 0;
    private static final String PARKING_LOT = "7";
    private static final String EMPTY_PARKING_LOT = "";
    private static final String PASSWORD_USER = "9";
    private static final String PASSWORD_USER_OVERLAP = "6";


    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        dataBase = mock(ReservationDataBase.class);
        model = new ReservationModel(dataBase);
        presenter = new ReservationPresenter(view, model);
    }

    private Calendar getStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, MONTH, DAY_START, HOUR, MINUTE);
        calendar.set(Calendar.SECOND, ZERO);
        calendar.set(Calendar.MILLISECOND, ZERO);
        return calendar;
    }

    private Calendar getEndDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, MONTH, DAY_END, HOUR, MINUTE);
        calendar.set(Calendar.SECOND, ZERO);
        calendar.set(Calendar.MILLISECOND, ZERO);
        return calendar;
    }

    private Calendar setCalendar(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar;
    }

    private Reservation createReservation() {
        Reservation overlapReservation = new Reservation();
        overlapReservation.setStartDate(setCalendar(YEAR, MONTH, DAY_START_OVERLAP, HOUR, MINUTE, ZERO, ZERO));
        overlapReservation.setEndDate(setCalendar(YEAR, MONTH, DAY_END_OVERLAP, HOUR, MINUTE, ZERO, ZERO));
        overlapReservation.setParkingLots(PARKING_LOT);
        overlapReservation.setUserPassword(PASSWORD_USER_OVERLAP);

        return overlapReservation;
    }

    @Test
    public void dateTimePickerButtonStartPressedTest() {
        presenter.dateTimePickerButtonStartPressed();

        verify(view).showDateTimeInfo(true);
    }

    @Test
    public void dateTimePickerButtonEndPressedTest() {
        presenter.dateTimePickerButtonEndPressed();

        verify(view).showDateTimeInfo(false);
    }

    @Test
    public void setReservationCalendarStartDateTest() {
        presenter.setReservationCalendar(getStartDate(), true);
        assertEquals(getStartDate(), model.getReservation().getStartDate());
    }

    @Test
    public void setReservationCalendarEndDateTest() {
        presenter.setReservationCalendar(getEndDate(), false);
        assertEquals(getEndDate(), model.getReservation().getEndDate());
    }

    @Test
    public void buttonSaveReservationTest() {
        model.setStartDate(getStartDate());
        model.setEndDate(getEndDate());
        reservation = model.createReservation(PARKING_LOT, PASSWORD_USER);
        when(view.getParkingLots()).thenReturn(PARKING_LOT);
        when(view.getUserPassword()).thenReturn(PASSWORD_USER);

        presenter.buttonSaveReservation();

        verify(view).showMessageOfSavedStatement(reservation);
        verify(view).dismissActivity();
    }

    @Test
    public void buttonSaveOverlapReservationTest() {
        when(view.getParkingLots()).thenReturn(PARKING_LOT);
        when(view.getUserPassword()).thenReturn(PASSWORD_USER);
        model.setStartDate(getStartDate());
        model.setEndDate(getEndDate());
        reservation = model.createReservation(PARKING_LOT, PASSWORD_USER);
        when(dataBase.getReservation(PARKING_LOT)).thenReturn(List.of(reservation));

        presenter.buttonSaveReservation();

        verify(view).showMessageOfOverlapReservation();
    }

    @Test
    public void buttonSaveReservationIncompleteFieldsTest() {
        when(view.getParkingLots()).thenReturn(EMPTY_PARKING_LOT);
        when(view.getUserPassword()).thenReturn(PASSWORD_USER);
        model.setStartDate(getStartDate());
        model.setEndDate(getEndDate());
        reservation = model.createReservation(EMPTY_PARKING_LOT, PASSWORD_USER);

        presenter.buttonSaveReservation();

        verify(view).showMessageOfError();
    }

    @Test
    public void buttonCancelReservationTest() {
        presenter.buttonCancelReservation();

        verify(view).dismissActivity();
    }

    @Test
    public void checkReservationTrueTest() {
        presenter.check(createReservation());

        assertEquals(true, presenter.check(createReservation()));
    }

}
