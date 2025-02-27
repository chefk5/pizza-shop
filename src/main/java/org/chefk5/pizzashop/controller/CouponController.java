package org.chefk5.pizzashop.controller;

import org.chefk5.pizzashop.service.CouponService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon/")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }


    @PostMapping("/coupons")
    public String generateCoupons() {
        couponService.generatecoupons();
        return "Successfully generated coupons";
    }

}
