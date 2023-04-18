package classes;

import models.IRoom;
import models.RoomType;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if ( this == object) return true;
        if (!(object instanceof IRoom)) return false;
        IRoom room = (IRoom) object;
        return Objects.equals(roomNumber, room.getRoomNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
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
        return " Room{ " + "roomNumber: " + roomNumber + " price: " + price + " roomType: " + enumeration + " }";
    }
    @Override
    public boolean isFree() {
        return false;
    }
}
