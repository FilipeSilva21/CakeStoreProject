package com.CakeStore.repositories;

import com.CakeStore.models.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake, Long> {
}
