package com.coffeedev.apiGeekCentral.repositories;

import com.coffeedev.apiGeekCentral.domain.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga,Integer> {
}
