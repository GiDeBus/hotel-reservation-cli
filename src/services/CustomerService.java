package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import models.Customer;

public final class CustomerService {

    private CustomerService() {};

    private static CustomerService customerService = new CustomerService();

    private static final Map<String, Customer> customers = new HashMap<>();

    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
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
