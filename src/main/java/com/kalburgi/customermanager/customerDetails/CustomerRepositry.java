package com.kalburgi.customermanager.customerDetails;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepositry extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
