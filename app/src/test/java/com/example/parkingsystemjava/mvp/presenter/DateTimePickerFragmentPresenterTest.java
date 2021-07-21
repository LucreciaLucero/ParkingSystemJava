package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.DateTimePickerListener;
import com.example.parkingsystemjava.mvp.contract.DateTimePickerContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class DateTimePickerFragmentPresenterTest {
    private DateTimePickerContract.PresenterContract presenter;
    @Mock
    private DateTimePickerContract.ViewContract view;
    @Mock
    private DateTimePickerListener dateTimePickerListener;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        presenter = new DateTimePickerFragmentPresenter(view);
    }

    @Test
    public void onSaveStartDateTimePickerButtonPressedTest() {
        presenter.onSaveButtonPressed(dateTimePickerListener, true);

        verify(view).saveReservationFields(dateTimePickerListener, true);
        verify(view).dismissDialogFragment();
    }

    @Test
    public void onSaveEndDateTimePickerButtonPressedTest() {
        presenter.onSaveButtonPressed(dateTimePickerListener, false);

        verify(view).saveReservationFields(dateTimePickerListener, false);
        verify(view).dismissDialogFragment();
    }

    @Test
    public void onCancelDateTimePickerButtonPressedTest() {
        presenter.onCancelButtonPressed();

        verify(view).dismissDialogFragment();
    }
}
