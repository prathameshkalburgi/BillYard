package com.kalburgi.customermanager.customerDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositry extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerById(Long id);
    void deleteCustomerById(Long id);

//    @Query("select c from customer c where c.email=?1")
//    List<Customer> findByNameWithIndex( String email);

    @Query(value = "SELECT *  from customer e where e.email=:email", nativeQuery = true)
    List<Customer> findByEmail(@Param("email") String email);

}
