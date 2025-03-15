package com.CakeStore.controllers;

import com.CakeStore.DTOs.CreateClientDTO;
import com.CakeStore.models.Client;
import com.CakeStore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody CreateClientDTO createClientDTO){

        var clientId = clientService.createClient(createClientDTO);

        return ResponseEntity.created(URI.create("v1/clients" + clientId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){

        var clients = clientService.getAllClients();

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> findClientById(@PathVariable("clientId") Long clientId) {

        var client = clientService.getClientById(clientId);

        return ResponseEntity.ok(client.get());
    }
}
