package models;

import models.Room;
import models.RoomType;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }
    public boolean isFree = true;

    @Override
    public Double getRoomPrice() {
        return 0.0;
    }

    @Override
    public boolean isFree() {
        return true;
    }
    @Override
    public String toString() {
        return " isFree: " + isFree + " " + super.toString();
    }
}
