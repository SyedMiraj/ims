package com.csl.b4.ims.customer.service;

import com.csl.b4.ims.customer.entity.CustomerEntity;
import com.csl.b4.ims.customer.mapper.CustomerMapper;
import com.csl.b4.ims.customer.model.Customer;
import com.csl.b4.ims.customer.repository.CustomerRepository;
import com.csl.b4.ims.customer.specification.CustomerSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public void saveCustomer(Customer customer){
        CustomerEntity entity = customerMapper.toEntity(customer);
        entity.setCreatedAt(LocalDate.now());
        customerRepository.save(entity);
    }

    public Page<Customer> findAllCustomers(Pageable pageable, String name, String address, String phone){
        Page<CustomerEntity> customers = customerRepository.findAll(CustomerSpecification.findSCustomers(name, address, phone), pageable);
        return customers.map(customerMapper::toDto);
    }

    public List<Customer> findAllCustomers(String name, String address, String phone){
        List<CustomerEntity> customers = customerRepository.findAll(CustomerSpecification.findSCustomers(name, address, phone));
        return customers.stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(Long id){
        CustomerEntity entity = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toDto(entity);
    }

    public boolean isExist(Long id) {
        return false;
    }
}
