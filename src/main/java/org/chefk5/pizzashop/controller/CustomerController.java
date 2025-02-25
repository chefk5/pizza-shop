package org.chefk5.pizzashop.controller;

import org.chefk5.pizzashop.dto.UserRequest;
import org.chefk5.pizzashop.dto.UserResponseDto;
import org.chefk5.pizzashop.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<UserResponseDto> getCustomer(@PathVariable Long id) {
        UserResponseDto userResponseDto = customerService.findCustomerById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/customer")
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
}
