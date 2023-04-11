package api;

import services.CustomerService;
import classes.Customer;
public class AdminResource {
    private static AdminResource adminResource = new AdminResource();
    public static AdminResource getAdminResource() {
        return adminResource;
    }

    public Customer getCustomer(String email) {
        return CustomerService.getCustomerService().getCustomer(email);
    }
}
