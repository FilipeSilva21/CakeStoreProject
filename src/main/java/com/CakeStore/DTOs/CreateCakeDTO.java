package com.CakeStore.DTOs;

import com.CakeStore.models.Client;
import com.CakeStore.models.enums.CakeType;

public record CreateCakeDTO(CakeType cakeType, Client buyer, int saleDate) {
}
