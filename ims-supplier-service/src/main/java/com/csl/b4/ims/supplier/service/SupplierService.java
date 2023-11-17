package com.csl.b4.ims.supplier.service;

import com.csl.b4.ims.supplier.entity.SupplierEntity;
import com.csl.b4.ims.supplier.mapper.SupplierMapper;
import com.csl.b4.ims.supplier.model.Supplier;
import com.csl.b4.ims.supplier.repository.SupplierRepository;
import com.csl.b4.ims.supplier.specification.SupplierSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    public void saveSupplier(Supplier supplier){
        SupplierEntity entity = supplierMapper.toEntity(supplier);
        entity.setCreatedAt(LocalDate.now());
        supplierRepository.save(entity);
    }

    public Page<Supplier> findAllSuppliers(Pageable pageable, String code, String name, String phone) {
        Page<SupplierEntity> suppliers = supplierRepository.findAll(SupplierSpecification.findSuppliers(code, name, phone), pageable);
        return suppliers.map(supplierMapper::toDto);
    }

    public List<Supplier> findAllSuppliers(String code, String name, String phone){
        List<SupplierEntity> suppliers = supplierRepository.findAll(SupplierSpecification.findSuppliers(code, name, phone));
        return suppliers.stream()
                .map(supplierMapper::toDto)
                .collect(Collectors.toList());
    }

    public Supplier getSupplierById(Long id){
        SupplierEntity entity = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return supplierMapper.toDto(entity);
    }

    public boolean isExist(Long id){
        return supplierRepository.existsById(id);
    }
}
