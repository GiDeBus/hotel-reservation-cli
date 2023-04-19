package classes;

import models.IRoom;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String toString() {
        return "customer: " + customer + " room: " + room + " checkInDate: " + checkInDate + " checkOutDate: " + checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;

        Reservation that = (Reservation) o;

        if (!getRoom().getRoomNumber().equals(that.getRoom().getRoomNumber())) return false;
        if (!getCheckInDate().equals(that.getCheckInDate())) return false;
        return getCheckOutDate().equals(that.getCheckOutDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoom().getRoomNumber(), getCheckInDate(), getCheckOutDate());
    }
}
