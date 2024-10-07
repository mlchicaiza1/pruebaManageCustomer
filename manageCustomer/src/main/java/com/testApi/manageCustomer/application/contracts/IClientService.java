package com.testApi.manageCustomer.application.contracts;

import com.testApi.manageCustomer.application.dtos.ClientDto;
import java.util.List;

/**
 *
 * @author mauro
 */
public interface IClientService {
    
    List<ClientDto> findAll();
    
    ClientDto findById(Long id);
    
    ClientDto save(ClientDto clientDto);
    
    ClientDto update(Long id,ClientDto clientDto);
    
    void deleteById(Long id); 
}
