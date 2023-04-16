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

    private static final Collection<Reservation> reservations = new ArrayList<>();

    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public void printAllReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<>();
        for (Reservation reservation: reservations) {
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
        Collection<Reservation> customerReservations = new ArrayList<>();
        for(Reservation reservation: reservations) {
            if(reservation.getCustomer().getEmail() == customer.getEmail()) {
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }
}
