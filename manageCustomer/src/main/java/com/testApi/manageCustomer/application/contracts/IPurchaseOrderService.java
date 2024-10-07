package com.testApi.manageCustomer.application.contracts;

import com.testApi.manageCustomer.application.dtos.PurchaseOrderDto;
import java.util.List;

/**
 *
 * @author mauro
 */
public interface IPurchaseOrderService {
    
    List<PurchaseOrderDto> findAll();
    
    PurchaseOrderDto findById(Long id);
 
    PurchaseOrderDto save(PurchaseOrderDto purchaseOrderDto);
    
    PurchaseOrderDto update(Long id,PurchaseOrderDto purchaseOrderDto);
    
    void deleteById(Long id);
}
