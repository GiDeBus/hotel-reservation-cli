package services;

import classes.Reservation;
import models.IRoom;
import classes.Customer;
import java.util.Date;

import java.util.*;

public final class ReservationService {

    private ReservationService() {

    }

    private static ReservationService reservationService = new ReservationService();

    public static ReservationService getInstance() {
        return reservationService;
    }

    private static final Collection<IRoom> rooms = new HashSet<>();

    private static final Collection<Reservation> reservations = new HashSet<>();

    public void addRoom(IRoom room) {
        if (rooms.contains(room)) {
            throw new IllegalArgumentException("Room already exists");
        }
        rooms.add(room);
    }

    public IRoom getARoom(String roomNumber) {
        for (IRoom room : rooms) {
            if(room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public Collection<IRoom> getAllRooms() {
        return rooms;
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
        Collection<IRoom> availableRooms = new ArrayList<>(rooms);
        for (Reservation reservation : reservations) {
            if ((checkInDate.before(reservation.getCheckOutDate()) && checkOutDate.after(reservation.getCheckInDate())) || (checkInDate.equals(reservation.getCheckInDate()) && checkOutDate.equals(reservation.getCheckOutDate()))) {
                availableRooms.remove(reservation.getRoom());
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
