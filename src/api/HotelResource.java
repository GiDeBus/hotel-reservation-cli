package api;

public class HotelResource {
    private static HotelResource hotelResource = new HotelResource();
    public static HotelResource getHotelResource() {
        return hotelResource;
    }
}
