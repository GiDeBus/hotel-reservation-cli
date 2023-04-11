package api;
import services.CustomerService;
import classes.*;

public class HotelResource {
    private static HotelResource hotelResource = new HotelResource();
    public static HotelResource getHotelResource() {
        return hotelResource;
    }

    public Customer getCustomer(String email) {
        CustomerService.getCustomerService().getCustomer(email);
    }
}
