package ru.otus.homework;

import java.util.*;

public class CustomerService {

    private final TreeMap<Customer, String> customers = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return getCopy(customers.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return getCopy(customers.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }

    private Map.Entry<Customer, String> getCopy(Map.Entry<Customer, String> entryForCopy) {
        if (entryForCopy == null) {
            return null;
        }
        Customer c = entryForCopy.getKey();
        String data = entryForCopy.getValue();
        Customer copiedCustomer = new Customer(c.getId(), c.getName(), c.getScores());
        return new AbstractMap.SimpleEntry<>(copiedCustomer, data);
    }
}
