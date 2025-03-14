package com.CakeStore.DTOs;

import com.CakeStore.models.Client;
import com.CakeStore.models.enums.CakeType;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record CreateCakeDTO(CakeType cakeType, Client buyer, LocalDate saleDate) {
}
