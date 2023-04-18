package classes;

import models.RoomType;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }

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
        return " Free Room: " + super.toString();
    }
}
