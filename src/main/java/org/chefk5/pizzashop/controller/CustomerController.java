package org.chefk5.pizzashop.controller;

import org.chefk5.pizzashop.dto.UserRequest;
import org.chefk5.pizzashop.dto.UserResponseDto;
import org.chefk5.pizzashop.service.CouponService;
import org.chefk5.pizzashop.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    private final CustomerService customerService;
    private final CouponService couponService;

    public CustomerController(CustomerService customerService, CouponService couponService) {
        this.customerService = customerService;
        this.couponService = couponService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getCustomer(@PathVariable Long id) {
        UserResponseDto userResponseDto = customerService.findCustomerById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> addCustomer(@RequestBody UserRequest userRequest) {
        UserResponseDto userResponseDto = customerService.addCustomer(userRequest);
        return ResponseEntity.ok(userResponseDto);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<UserResponseDto> updateCustomer(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserResponseDto userResponseDto = customerService.updateCustomer(id, userRequest);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted");

    }

    @PostMapping("/coupon")
    public ResponseEntity<String> assignCouponToCustomer() {
        return ResponseEntity.ok(couponService.assignCouponToCustomer());
    }
}
