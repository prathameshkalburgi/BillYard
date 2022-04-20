package com.kalburgi.customermanager.customerDetails;

import com.kalburgi.customermanager.Exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepositry customerRepositry;

    public CustomerService(CustomerRepositry customerRepositry) {
        this.customerRepositry = customerRepositry;
    }

    public Customer addCustomer(Customer customer)  {
        if(!customerRepositry.findByEmail(customer.getEmail()).isEmpty()) throw new RuntimeException(""+customerRepositry.findByEmail(customer.getEmail()));
        customer.setCreatedTime(new Date());
        return customerRepositry.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepositry.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepositry.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepositry.findCustomerById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepositry.deleteCustomerById(id);
    }
}
