package org.chefk5.pizzashop.service;

import lombok.AllArgsConstructor;
import org.chefk5.pizzashop.domain.Customer;
import org.chefk5.pizzashop.dto.UserRequest;
import org.chefk5.pizzashop.dto.UserResponseDto;
import org.chefk5.pizzashop.exception.ResourceNotFoundException;
import org.chefk5.pizzashop.repo.CustomerRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }


    public UserResponseDto findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return toUserResponseDto(customer);
    }

    public UserResponseDto addCustomer(UserRequest userRequest) {

        // TODO: Add validation

        Customer customer = Customer.builder()
                .email(userRequest.email())
                .username(userRequest.username())
                .password(userRequest.password())
                .build();

        customerRepository.saveAndFlush(customer);

        return toUserResponseDto(customer);
    }

    private UserResponseDto toUserResponseDto(Customer customer) {
        return UserResponseDto.builder()
                .username(customer.getUsername())
                .email(customer.getEmail())
                .build();


    }

    public UserResponseDto updateCustomer(Long id, UserRequest userRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customer.setUsername(userRequest.username());
        customer.setEmail(userRequest.email());
        customer.setPassword(userRequest.password());
        customerRepository.saveAndFlush(customer);
        return toUserResponseDto(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customerRepository.delete(customer);
    }
}
