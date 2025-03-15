package com.CakeStore.repositories;

import com.CakeStore.models.Cake;
import com.CakeStore.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CakeRepository extends JpaRepository<Cake, Long> {
}
