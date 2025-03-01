package org.chefk5.pizzashop.repo;

import org.chefk5.pizzashop.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @Query(value = "SELECT * FROM Coupon  where customer_id IS NULL LIMIT 1", nativeQuery = true)
    Coupon findAvailableCoupon();
}
