package com.testApi.manageCustomer.infraestructure.mapper;

import com.testApi.manageCustomer.application.dtos.PurchaseOrderDto;
import com.testApi.manageCustomer.infraestructure.models.PurchaseOrder;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mauro
 */
@Component
public class PurchaseOrderMapper {

    private final ModelMapper modelMapper;
    private final ClientMapper clientMapper;
    private final ArticleMapper articleMapper;

    @Autowired
    public PurchaseOrderMapper(ModelMapper modelMapper, ClientMapper clientMapper, ArticleMapper articleMapper) {
        this.modelMapper = modelMapper;
        this.clientMapper = clientMapper;
        this.articleMapper = articleMapper;
    }

    public PurchaseOrderDto mapEntityToDto(PurchaseOrder purchaseOrder) {
        PurchaseOrderDto purchaseOrderDto = modelMapper.map(purchaseOrder, PurchaseOrderDto.class);
        
        purchaseOrderDto.setClient(clientMapper.mapEntityToDto(purchaseOrder.getClient()));
        purchaseOrderDto.setArticles(articleMapper.mapEntitiesToDtos(purchaseOrder.getArticles()));

        return purchaseOrderDto;
    }

    public PurchaseOrder mapDtoToEntity(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDto, PurchaseOrder.class);
        
        purchaseOrder.setClient(clientMapper.mapDtoToEntity(purchaseOrderDto.getClient()));
        purchaseOrder.setArticles(articleMapper.mapDtosToEntities(purchaseOrderDto.getArticles()));

        return purchaseOrder;
    }
    
    public List<PurchaseOrderDto> mapEntitiesToDtos(List<PurchaseOrder> purchaseOrders) {
        return purchaseOrders.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public List<PurchaseOrder> mapDtosToEntities(List<PurchaseOrderDto> purchaseOrderDtos) {
        return purchaseOrderDtos.stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());
    }
}