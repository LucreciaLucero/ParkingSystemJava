package com.example.parkingsystemjava.database;

import com.example.parkingsystemjava.ReservationObject.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public Reservation getReservation(String parkingLots, String pass) {
        List<Reservation> listReservation = reservationHashMap.get(parkingLots);
        if (listReservation != null) {
            for (Reservation reservation : listReservation) {
                if (reservation.getUserPassword().equals(pass)) {
                    return reservation;
                }
            }
        }
        return null;
    }

    public List<Reservation> getReservation(String parkingLots) {
        return reservationHashMap.get(parkingLots);
    }
}
