import models.RoomType;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super();
        this.roomNumber = roomNumber;
        this.price = 0.0;
        this.enumeration = enumeration;
    }

    @Override
    public String toString() {
        return super().toString() + " Room Number: " + roomNumber + " Room Price: " + "Free" + " Room Type: " + enumeration;
    }
}
