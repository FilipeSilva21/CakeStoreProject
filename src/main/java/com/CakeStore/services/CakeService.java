package com.CakeStore.services;

import com.CakeStore.DTOs.CreateCakeDTO;
import com.CakeStore.models.Cake;
import com.CakeStore.models.Client;
import com.CakeStore.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public Long createCake(CreateCakeDTO createCakeDTO, Client clientId) {

        LocalDate validateDate = createCakeDTO.saleDate();

        validateDate = switch (createCakeDTO.cakeType()) {
            case confeitado -> validateDate.plusDays(2);
            case dePote -> validateDate.plusDays(30);
            case gourmet -> validateDate.plusDays(10);
            case simples -> validateDate.plusDays(6);
        };

        var cake = new Cake(
                null,
                createCakeDTO.cakeType(),
                validateDate,
                createCakeDTO.saleDate(),
                createCakeDTO.paymentMethod(),
                clientId
        );

        var savedCake = cakeRepository.save(cake);

        return savedCake.getCakeId();
    }

    public List<Cake> getAllCakesMade(){

        return cakeRepository.findAll();
    }

    public Optional<Cake> getCakeById (Long cakeId){

        return cakeRepository.findById(cakeId);
    }

    public List<Cake> getAllCakesFromClient (Long clientId) {

        return cakeRepository.findAllById(Collections.singleton(clientId));
    }
}
