package com.pikej.customer;

import com.pikej.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {


    private final CustomerRepository customerRepository  ;


    List<Customer> getCustomers(){
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        return customerRepository
                .findById(id)
                .orElseThrow(()->{
                    NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                    log.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }


}