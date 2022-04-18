package com.kalburgi.customermanager.customerDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepositry extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long id);

//    List<Customer> findByEmail(String email);

    void deleteCustomerById(Long id);
}
