package com.coffeedev.apiGeekCentral.repositories;

import com.coffeedev.apiGeekCentral.domain.Popular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopularRepository extends JpaRepository<Popular,Integer> {
}
