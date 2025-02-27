package org.chefk5.pizzashop.service;

import lombok.AllArgsConstructor;
import org.chefk5.pizzashop.domain.Coupon;
import org.chefk5.pizzashop.repo.CouponRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public void giveCouponToCustomer(int id) {


    }

    public void generatecoupons() {
        int coupons = 500;

        for (int i = 0; i < coupons; i++) {
            String code = String.valueOf(Math.random() * 10000);
            Coupon coupon = Coupon.builder().code(code).build();
            couponRepository.save(coupon);

        }
    }
}
