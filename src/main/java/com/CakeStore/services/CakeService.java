package com.CakeStore.services;

import com.CakeStore.DTOs.CreateCakeDTO;
import com.CakeStore.models.Cake;
import com.CakeStore.models.Client;
import com.CakeStore.models.enums.CakeType;
import com.CakeStore.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public Long createCake (Cake cake, CreateCakeDTO createCakeDTO, Client buyer){

        if (cake.getCakeType() == CakeType.confeitado) {
            cake.setValidateDate(cake.getValidateDate().plusDays(2));
        }

        if (cake.getCakeType() == CakeType.dePote) {
            cake.setValidateDate(cake.getValidateDate().plusDays(30));
        }

        if (cake.getCakeType() == CakeType.gourmet) {
            cake.setValidateDate(cake.getValidateDate().plusDays(10));
        }

        if (cake.getCakeType() == CakeType.simples) {
            cake.setValidateDate(cake.getValidateDate().plusDays(6));
        }

        var cakes = new Cake(
                null,
              createCakeDTO.cakeType(),
              cake.getValidateDate(),
              createCakeDTO.saleDate(),
              buyer
        );

        var cakeMade = cakeRepository.save(cakes);

        return cakeMade.getCakeId();
    }

    public List<Cake> getAllCakesMade(){

        return cakeRepository.findAll();
    }

    public Optional<Cake> getCakeById (Long cakeId){

        return cakeRepository.findById(cakeId);
    }
}
