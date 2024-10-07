package com.testApi.manageCustomer.infraestructure.repositories;

import com.testApi.manageCustomer.infraestructure.models.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauro
 */
public interface PurchaseOrderRepository  extends JpaRepository<PurchaseOrder, Long> {
    
}
