package com.example.parkingsystemjava.database;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import com.example.parkingsystemjava.utils.ConstantUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ReservationDataBase {
    private static ReservationDataBase reservationDataBase;
    private final Map<String, List<Reservation>> reservationHashMap;

    public ReservationDataBase() {
        this.reservationHashMap = new HashMap<>();
    }

    public static ReservationDataBase getInstance() {
        if (reservationDataBase == null) {
            reservationDataBase = new ReservationDataBase();
        }
        return reservationDataBase;
    }

    public void addValues(Reservation reservation) {
        String parkingLots = reservation.getParkingLots();
        if (reservationHashMap.get(parkingLots) == null) {
            List<Reservation> reservations = new ArrayList<>();
            reservations.add(reservation);
            reservationHashMap.put(parkingLots, reservations);
        } else {
            reservationHashMap.get(parkingLots).add(reservation);
        }
    }

    public List<Reservation> getReservation(String parkingLots) {
        return reservationHashMap.get(parkingLots);
    }

    public int releasePastReservations() {
        int numberOfReservationsDeleted = ConstantUtils.ZERO;
        Calendar todayDate = Calendar.getInstance(Locale.getDefault());
        for (List<Reservation> listReservation : reservationHashMap.values()) {
            if (listReservation != null) {
                for (Reservation reservation : listReservation)
                    if (reservation.getEndDate().before(todayDate)) {
                        listReservation.remove(reservation);
                        numberOfReservationsDeleted++;
                    }
            }
        }
        return numberOfReservationsDeleted;
    }
}
