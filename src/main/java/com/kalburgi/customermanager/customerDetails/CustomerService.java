package com.kalburgi.customermanager.customerDetails;

import com.kalburgi.customermanager.Exception.UserNotFoundException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerService {

    @Autowired
   CustomerRepositry customerRepositry;

    public Customer addCustomer(Customer customer)  {

        customer.setCustomerCode(UUID.randomUUID().toString());
        customer.setCreatedTime(new Date());
        customer.setEnabled(false);

        String randomCode = RandomString.make(64);
        customer.setVerificationCode(randomCode);
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
