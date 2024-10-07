package com.testApi.manageCustomer.infraestructure.services;

import com.testApi.manageCustomer.infraestructure.mapper.ClientMapper;
import com.testApi.manageCustomer.application.dtos.ClientDto;
import com.testApi.manageCustomer.infraestructure.contracts.IClientRepository;
import com.testApi.manageCustomer.infraestructure.repositories.ClientRepository;
import java.util.List;
import com.testApi.manageCustomer.infraestructure.models.Client;
import com.testApi.manageCustomer.utils.exceptions.ResourceNotFoundException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author mauro
 */

@Repository("client")
public class JpaClientService implements IClientRepository {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public JpaClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clientMapper.mapEntitiesToDtos(clients);
    }

    @Override
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        return clientMapper.mapEntityToDto(client);
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = clientMapper.mapDtoToEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return clientMapper.mapEntityToDto(savedClient);
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());

        Client updatedClient = clientRepository.save(client);
        return clientMapper.mapEntityToDto(updatedClient);
    }

    @Override
    public void deleteById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        
        clientRepository.delete(client);
    }
}
