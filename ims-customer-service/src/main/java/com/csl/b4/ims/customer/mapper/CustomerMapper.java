package com.csl.b4.ims.customer.mapper;

import com.csl.b4.ims.customer.entity.CustomerEntity;
import com.csl.b4.ims.customer.model.Customer;
import com.csl.b4.ims.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final CustomerRepository customerRepository;

    public CustomerMapper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity toEntity(Customer dto){
        CustomerEntity entity = customerRepository.findById(dto.getId())
                .orElse(new CustomerEntity());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        return entity;
    }
    public Customer toDto(CustomerEntity entity){
        Customer dto = new Customer();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
