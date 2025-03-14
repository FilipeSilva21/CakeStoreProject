package com.CakeStore.DTOs;

import java.time.LocalDate;

public record CreateClientDTO(String name, LocalDate birthday) {
}
