package com.coffeedev.apiGeekCentral.repositories;

import com.coffeedev.apiGeekCentral.domain.Hosted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostedRepository extends JpaRepository<Hosted,Integer> {
}
