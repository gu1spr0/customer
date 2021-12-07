package com.yorisapp.customer.model.repository;

import com.yorisapp.customer.model.entity.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
@Qualifier("CustomerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    @Query(value = "select c from Customer c where c.state=?1")
    List<Customer> getCustomersByState(String pState);

    @Query(value = "select c from Customer c where c.state=?1")
    List<Customer> getCustomersPageableByState(String pState, Pageable pPageable);

    @Query(value = "select count(c) from Customer c where c.state=?1")
    long getCountCustomersByState(String pState);
}
