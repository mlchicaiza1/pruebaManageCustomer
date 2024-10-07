package com.testApi.manageCustomer.api.controllers;

import com.testApi.manageCustomer.application.dtos.ClientDto;
import com.testApi.manageCustomer.application.service.ClientService;
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
@RequestMapping("/v1/api/client")
public class ClientController {
    
    private final ClientService service; 

    public ClientController(ClientService clientService) {
        this.service = clientService;
    }
    
    
    @GetMapping
    public List<ClientDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> show(@PathVariable Long id) {
        ClientDto clientDto = service.findById(id);
        return ResponseEntity.ok(clientDto);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@RequestBody ClientDto clientDto) {
        return service.save(clientDto);
    }

    @PutMapping("/{id}")
    public ClientDto update(@PathVariable Long id, @RequestBody ClientDto clientDto) {

        
        return service.update(id,clientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> delete(@PathVariable Long id) {       
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
