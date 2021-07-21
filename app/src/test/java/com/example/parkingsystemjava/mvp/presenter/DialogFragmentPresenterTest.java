package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ParkingDialogFragmentListener;
import com.example.parkingsystemjava.mvp.contract.DialogFragmentContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class DialogFragmentPresenterTest {
    private DialogFragmentContract.PresenterContract presenter;
    @Mock
    private DialogFragmentContract.ViewContract view;
    @Mock
    private ParkingDialogFragmentListener dialogFragmentListener;
    private final static String PARKING_LOT_STRING = "10";
    private final static String PARKING_LOT_EMPTY_STRING = "";

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        presenter = new DialogFragmentPresenter(view);
    }

    @Test
    public void onSaveButtonPressedTest() {
        when(view.getParkingsAvailable()).thenReturn(PARKING_LOT_STRING);

        presenter.onSaveButtonPressed(dialogFragmentListener);

        verify(view).dismissDialogFragmentParkingLots();
    }

    @Test
    public void onSaveButtonPressedEmptyStringTest() {
        when(view.getParkingsAvailable()).thenReturn(PARKING_LOT_EMPTY_STRING);

        presenter.onSaveButtonPressed(dialogFragmentListener);

        verify(view).dismissDialogFragmentParkingLots();
    }

    @Test
    public void onCancelButtonPressed() {
        presenter.onCancelButtonPressed();

        verify(view).dismissDialogFragmentParkingLots();
    }
}
