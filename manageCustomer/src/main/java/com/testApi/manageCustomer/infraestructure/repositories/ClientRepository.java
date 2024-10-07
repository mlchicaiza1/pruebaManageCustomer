package com.testApi.manageCustomer.infraestructure.repositories;


import com.testApi.manageCustomer.infraestructure.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauro
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}