package com.mahindra.tech.repositories;

import com.mahindra.tech.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
