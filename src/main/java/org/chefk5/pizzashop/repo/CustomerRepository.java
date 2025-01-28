package org.chefk5.pizzashop.repo;

import org.chefk5.pizzashop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

}
