package com.csl.b4.ims.product.service;

import com.csl.b4.ims.product.entity.PurchaseOrderDetailsEntity;
import com.csl.b4.ims.product.entity.PurchaseOrderEntity;
import com.csl.b4.ims.product.feign.SupplierService;
import com.csl.b4.ims.product.mapper.PurchaseMapper;
import com.csl.b4.ims.product.model.InventoryActivity;
import com.csl.b4.ims.product.model.ProductWiseQuantity;
import com.csl.b4.ims.product.model.PurchaseOrderRequest;
import com.csl.b4.ims.product.repository.PurchaseOrderDetailsRepository;
import com.csl.b4.ims.product.repository.PurchaseOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PurchaseService {

    private final PurchaseOrderRepository orderRepository;
    private final PurchaseOrderDetailsRepository orderDetailsRepository;
    private final PurchaseMapper purchaseMapper;
    private final SupplierService supplierService;
    private final ProductService productService;

    public PurchaseService(PurchaseOrderRepository orderRepository, PurchaseOrderDetailsRepository orderDetailsRepository, PurchaseMapper purchaseMapper, SupplierService supplierService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.purchaseMapper = purchaseMapper;
        this.supplierService = supplierService;
        this.productService = productService;
    }

    @Transactional
    public void saveOrder(PurchaseOrderRequest purchaseOrderRequest) {
        log.info("New purchase order to supplier " + purchaseOrderRequest.getSupplierId());
        if(!supplierService.isExist(purchaseOrderRequest.getSupplierId())){
            throw new RuntimeException("Supplier not found with id " + purchaseOrderRequest.getSupplierId());
        }
        PurchaseOrderEntity orderEntity = purchaseMapper.toOrderEntity(purchaseOrderRequest);
        orderEntity.setEntryUsername(purchaseOrderRequest.getEntryUsername());
        orderRepository.save(orderEntity);
        List<PurchaseOrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
        for(ProductWiseQuantity productWiseQuantity : purchaseOrderRequest.getProductWiseQuantitySet()){
            PurchaseOrderDetailsEntity orderDetailsEntity = purchaseMapper.toOrderDetailsEntity(productWiseQuantity, orderEntity);
            orderDetailsEntities.add(orderDetailsEntity);
            log.info("Updating stock of the product with id " + productWiseQuantity.getProductId());
            productService.updateProductStock(productWiseQuantity.getProductId(), productWiseQuantity.getQuantity(), InventoryActivity.Purchase);
        }
        orderDetailsRepository.saveAll(orderDetailsEntities);
    }
}
