package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import classes.Customer;

public class CustomerService {

    private static CustomerService customerService = new CustomerService();
    private static final Map<String, Customer> customers = new HashMap<>();

    // Instead of getInstance() method
    public static CustomerService getCustomerService() {
        return customerService;
    }
    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.put(email, customer);
    }
    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }
    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
