package org.chefk5.pizzashop.service;

import lombok.AllArgsConstructor;
import org.chefk5.pizzashop.domain.Customer;
import org.chefk5.pizzashop.repo.CustomerRepository;

@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }


}
