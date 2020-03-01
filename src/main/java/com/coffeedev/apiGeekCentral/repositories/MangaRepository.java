package com.coffeedev.apiGeekCentral.repositories;

import com.coffeedev.apiGeekCentral.domain.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga,Integer> {

    List<Manga> findByTitle(String title);
}
