package com.testApi.manageCustomer.infraestructure.services;

import com.testApi.manageCustomer.application.dtos.PurchaseOrderDto;
import com.testApi.manageCustomer.infraestructure.contracts.IPurchaseOrderRepository;
import com.testApi.manageCustomer.infraestructure.mapper.PurchaseOrderMapper;
import com.testApi.manageCustomer.infraestructure.repositories.PurchaseOrderRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.testApi.manageCustomer.infraestructure.models.PurchaseOrder;
import com.testApi.manageCustomer.utils.exceptions.ResourceNotFoundException;
/**
 *
 * @author mauro
 */

@Repository("purchaseOrder")
public class JpaPurchaseOrderService implements IPurchaseOrderRepository{

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    public JpaPurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, PurchaseOrderMapper purchaseOrderMapper) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderMapper = purchaseOrderMapper;
    }
    
   
    @Override
    public List<PurchaseOrderDto> findAll() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
        return purchaseOrderMapper.mapEntitiesToDtos(purchaseOrders);
    }

    @Override
    public PurchaseOrderDto findById(Long id) {
       PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase Order not found with id: " + id));
        return purchaseOrderMapper.mapEntityToDto(purchaseOrder);
    }

    @Override
    public PurchaseOrderDto save(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = purchaseOrderMapper.mapDtoToEntity(purchaseOrderDto);
        PurchaseOrder savedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        
        return purchaseOrderMapper.mapEntityToDto(savedPurchaseOrder);
    }

    @Override
    public PurchaseOrderDto update(Long id, PurchaseOrderDto purchaseOrderDto) {
       
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase Order not found with id: " + id));
       
       purchaseOrder.setCode(purchaseOrderDto.getCode());
       purchaseOrder.setDate(purchaseOrderDto.getDate());
       
       
       purchaseOrder.setClient(purchaseOrderMapper.mapDtoToEntity(purchaseOrderDto).getClient());
       purchaseOrder.setArticles(purchaseOrderMapper.mapDtoToEntity(purchaseOrderDto).getArticles());

        
        PurchaseOrder updatedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        
        return purchaseOrderMapper.mapEntityToDto(updatedPurchaseOrder);
    }

    @Override
    public void deleteById(Long id) {
       PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase Order not found with id: " + id));
        
        purchaseOrderRepository.delete(purchaseOrder);
    }
    
}
