package com.testApi.manageCustomer.application.service;

import com.testApi.manageCustomer.application.contracts.IPurchaseOrderService;
import com.testApi.manageCustomer.application.dtos.PurchaseOrderDto;
import com.testApi.manageCustomer.infraestructure.contracts.IPurchaseOrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauro
 */
@Service
public class PurchaseOrderService implements IPurchaseOrderService{
    
    @Qualifier("purchaseOrder")
    private final IPurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(IPurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }
    
    @Override
    public List<PurchaseOrderDto> findAll() {
       return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrderDto findById(Long id) {
       return purchaseOrderRepository.findById(id);
    }

    @Override
    public PurchaseOrderDto save(PurchaseOrderDto purchaseOrderDto) {
       return purchaseOrderRepository.save(purchaseOrderDto);
    }

    @Override
    public PurchaseOrderDto update(Long id, PurchaseOrderDto purchaseOrderDto) {
        return purchaseOrderRepository.update(id, purchaseOrderDto);
    }

    @Override
    public void deleteById(Long id) {
       purchaseOrderRepository.deleteById(id);
    }
    
}
