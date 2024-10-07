package com.testApi.manageCustomer.infraestructure.mapper;

import com.testApi.manageCustomer.application.dtos.ClientDto;
import com.testApi.manageCustomer.infraestructure.models.Client;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author mauro
 */
@Component
public class ClientMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClientDto mapEntityToDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    public Client mapDtoToEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    public List<ClientDto> mapEntitiesToDtos(List<Client> clients) {
        return clients.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public List<Client> mapDtosToEntities(List<ClientDto> clientDtos) {
        return clientDtos.stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());
    }
}
