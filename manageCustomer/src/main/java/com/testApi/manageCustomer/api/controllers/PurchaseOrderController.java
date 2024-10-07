package com.testApi.manageCustomer.api.controllers;

import com.testApi.manageCustomer.application.dtos.PurchaseOrderDto;
import com.testApi.manageCustomer.application.service.PurchaseOrderService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mauro
 */

@RestController
@RequestMapping("/v1/api/order")
public class PurchaseOrderController {
    
    private final PurchaseOrderService service; 

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }
 
    
    @GetMapping
    public List<PurchaseOrderDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderDto> show(@PathVariable Long id) {
        PurchaseOrderDto purchaseOrderDto = service.findById(id);
        return ResponseEntity.ok(purchaseOrderDto);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrderDto create(@RequestBody PurchaseOrderDto purchaseOrderDto) {
        return service.save(purchaseOrderDto);
    }

    @PutMapping("/{id}")
    public PurchaseOrderDto update(@PathVariable Long id, @RequestBody PurchaseOrderDto purchaseOrderDto) {
        return service.update(id,purchaseOrderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseOrderDto> delete(@PathVariable Long id) {       
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
