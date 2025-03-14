package com.CakeStore.services;

import com.CakeStore.DTOs.CreateClientDTO;
import com.CakeStore.models.Cake;
import com.CakeStore.models.Client;
import com.CakeStore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Long createClient (CreateClientDTO createClientDTO){

        var client = new Client(
                null,
                createClientDTO.name(),
                createClientDTO.birthday(),
                null
        );

        var clientCreated = clientRepository.save(client);

        return clientCreated.getClientId();
    }

    public List<Client> getAllClients(){

        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long clientId){

        return clientRepository.findById(clientId);
    }
}
