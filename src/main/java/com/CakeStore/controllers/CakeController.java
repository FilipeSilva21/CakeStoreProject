package com.CakeStore.controllers;

import com.CakeStore.DTOs.CreateCakeDTO;
import com.CakeStore.models.Cake;
import com.CakeStore.models.Client;
import com.CakeStore.repositories.ClientRepository;
import com.CakeStore.services.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cakes")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/{clientId}")
    public ResponseEntity<Cake> createCake(@RequestBody CreateCakeDTO createCakeDTO, @PathVariable Client clientId){

        var cakeId = cakeService.createCake(createCakeDTO, clientId);

        return ResponseEntity.created(URI.create("v1/cake" + cakeId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Cake>> getAllCakesMade(){

        var cakes = cakeService.getAllCakesMade();

        return ResponseEntity.ok(cakes);
    }

    @GetMapping("/{cakeId}")
    public ResponseEntity<Cake> findCakeById(@PathVariable("cakeId") Long cakeId) {

        var cake = cakeService.getCakeById(cakeId);

        return ResponseEntity.ok(cake.get());
    }

    @GetMapping("/{clientId}/cakes")
    public List<Cake> getAllCakesFromClient(@PathVariable Long clientId) {

        Optional<Client> clientOptional = clientRepository.findById(clientId);

        return cakeService.getAllCakesFromClient(clientId);
    }
}
