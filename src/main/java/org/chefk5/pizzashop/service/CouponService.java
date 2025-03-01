package org.chefk5.pizzashop.service;

import lombok.AllArgsConstructor;
import org.chefk5.pizzashop.domain.Coupon;
import org.chefk5.pizzashop.domain.Customer;
import org.chefk5.pizzashop.repo.CouponRepository;
import org.chefk5.pizzashop.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import static org.chefk5.pizzashop.utils.generatorsUtil.generateRandomEmail;

@Service
@AllArgsConstructor
public class CouponService {

    final CouponRepository couponRepository;
    private final CustomerRepository customerRepository;


    public String assignCouponToCustomer() {

        Coupon availableCoupon = couponRepository.findAvailableCoupon();
        Customer newCustomer = Customer.builder()
                .email(generateRandomEmail())
                .username(generateRandomEmail())
                .password(generateRandomEmail())
                .build();
        availableCoupon.setCustomer(newCustomer);
        customerRepository.saveAndFlush(newCustomer);
        return availableCoupon.getCode();
    }


}
