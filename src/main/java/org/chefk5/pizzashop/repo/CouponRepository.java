package org.chefk5.pizzashop.repo;

import org.chefk5.pizzashop.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    
}
