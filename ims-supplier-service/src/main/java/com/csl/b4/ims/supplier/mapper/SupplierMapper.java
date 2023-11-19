package com.csl.b4.ims.supplier.mapper;

import com.csl.b4.ims.supplier.entity.SupplierEntity;
import com.csl.b4.ims.supplier.model.Supplier;
import com.csl.b4.ims.supplier.repository.SupplierRepository;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    private final SupplierRepository supplierRepository;

    public SupplierMapper(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity toEntity(Supplier dto){
        SupplierEntity entity = supplierRepository.findById(dto.getId())
                .orElse(new SupplierEntity());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    public Supplier toDto(SupplierEntity entity){
        Supplier dto = new Supplier();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
