package com.coffeedev.apiGeekCentral.repositories;

import com.coffeedev.apiGeekCentral.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Authorrepository extends JpaRepository<Author,Integer> {
}
