package services;

import classes.Reservation;
import models.IRoom;
import classes.Customer;
import java.util.Date;

import java.util.*;

public class ReservationService {

    private static ReservationService reservationService = new ReservationService();
    public static ReservationService getReservationService() {
        return reservationService;
    }
    private static final Map<String, IRoom> rooms = new HashMap<>();
    private static final Map<String, Reservation> reservations = new HashMap<>();
    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.put(customer.getEmail(), reservation);
        return reservation;
    }

    public void printAllReservations() {
        for (Reservation reservation : reservations.values()) {
            System.out.println(reservation);
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<>();
        for (Reservation reservation: reservations.values()) {
            if(reservation.getCheckInDate().compareTo(checkOutDate) <= 1 && reservation.getCheckOutDate().compareTo(checkInDate) >= -1) {
                availableRooms.add(reservation.getRoom());
            }
        }
        for (IRoom room : rooms.values()) {
            if(!availableRooms.contains(room)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {

    }
}
