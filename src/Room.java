import models.IRoom;
import models.RoomType;

import java.util.Enumeration;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }
    @Override
    public String toString() {
        return super().toString() + " Room Number: " + roomNumber + " Room Price: " + price + " Room Type: " + enumeration;
    }
}
