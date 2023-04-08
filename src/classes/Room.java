package classes;

import models.IRoom;
import models.RoomType;

import java.util.Enumeration;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }
    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    @Override
    public Double getRoomPrice() {
        return price;
    }

    public void setRoomPrice(Double price) {
        this.price = price;
    }
    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    public void setRoomType( RoomType enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public String toString() {
        return " classes.Room Number: " + roomNumber + " classes.Room Price: " + price + " classes.Room Type: " + enumeration;
    }
    @Override
    public boolean isFree() {
        return false;
    }
}
