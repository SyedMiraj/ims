package com.csl.b4.ims.product.mapper;

import com.csl.b4.ims.product.entity.PurchaseOrderDetailsEntity;
import com.csl.b4.ims.product.entity.PurchaseOrderEntity;
import com.csl.b4.ims.product.model.ProductWiseQuantity;
import com.csl.b4.ims.product.model.PurchaseOrderRequest;
import com.csl.b4.ims.product.repository.ProductRepository;
import com.csl.b4.ims.product.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PurchaseMapper {

    private final PurchaseOrderRepository orderRepository;
    private final ProductRepository productRepository;

    public PurchaseMapper(PurchaseOrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public PurchaseOrderEntity toOrderEntity(PurchaseOrderRequest orderRequest){
        PurchaseOrderEntity entity = orderRepository.findById(orderRequest.getOrderRequestId())
                .orElse(new PurchaseOrderEntity());
        entity.setOrderNumber(orderRequest.getOrderNumber());
        entity.setOrderDate(orderRequest.getOrderDate());
        entity.setSupplierId(orderRequest.getSupplierId());
        entity.setPaidAmount(orderRequest.getPaidAmount());
        entity.setDueAmount(orderRequest.getDueAmount());
        return entity;
    }

    public PurchaseOrderDetailsEntity toOrderDetailsEntity(ProductWiseQuantity productWiseQuantity, PurchaseOrderEntity purchaseOrderEntity){
        PurchaseOrderDetailsEntity entity = new PurchaseOrderDetailsEntity();
        productRepository.findById(productWiseQuantity.getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not found with id " + productWiseQuantity.getProductId()));
        entity.setProductId(productWiseQuantity.getProductId());
        entity.setRate(productWiseQuantity.getRate());
        entity.setQuantity(productWiseQuantity.getQuantity());
        entity.setAmount(productWiseQuantity.getQuantity() > 0 ? productWiseQuantity.getRate().multiply(BigDecimal.valueOf(productWiseQuantity.getQuantity())) : BigDecimal.ZERO);
        entity.setPurchase(purchaseOrderEntity);
        return entity;
    }
}
