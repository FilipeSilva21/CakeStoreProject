package com.CakeStore.DTOs;

import com.CakeStore.models.enums.CakeType;
import com.CakeStore.models.enums.PaymentMethod;

import java.time.LocalDate;

public record CreateCakeDTO(CakeType cakeType, PaymentMethod paymentMethod, LocalDate saleDate) {
}
