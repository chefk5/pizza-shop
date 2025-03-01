package org.chefk5.pizzashop.seed;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.chefk5.pizzashop.domain.Coupon;
import org.chefk5.pizzashop.repo.CouponRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
@AllArgsConstructor
public class CouponSeeder {
    private static final Integer COUPONS_LENGTH = 500;

    private final CouponRepository couponRepository;

    @PostConstruct
    public void seedCoupons() {
        System.out.println("Deleting all coupons");
        couponRepository.deleteAll();
        System.out.println("Deleting successful");

//        if (couponRepository.count() > 0) {
//            System.out.println("Coupons seeded. Skipping...");
//            return;
//        }
        generateCoupons();


    }

    public void generateCoupons() {
        List<Coupon> coupons = new ArrayList<>();

        for (int i = 0; i < COUPONS_LENGTH; i++) {
            String code = "COUPON" + new Random().nextInt(10000);
            coupons.add(Coupon.builder()
                    .code(code)
                    .customer(null)
                    .build());

        }
        couponRepository.saveAll(coupons);
        System.out.println("Coupon seeding completed.");

    }
}
