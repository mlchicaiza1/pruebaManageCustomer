package com.testApi.manageCustomer.application.service;

import com.testApi.manageCustomer.application.contracts.IClientService;
import com.testApi.manageCustomer.application.dtos.ClientDto;
import com.testApi.manageCustomer.infraestructure.contracts.IClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauro
 */
@Service
public class ClientService implements IClientService{

    @Qualifier("client")
    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public List<ClientDto> findAll() {
       return clientRepository.findAll();
    }
    
        
    @Override
    public ClientDto findById(Long id) {
       return clientRepository.findById(id);
    }
    
    @Override
    public ClientDto save(ClientDto clientDto) {
        return  clientRepository.save(clientDto);
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        return  clientRepository.update(id,clientDto);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }   
}
