package com.mahindra.tech.repositories;

import com.mahindra.tech.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    public Page<City> findByCountryId(Long countryId, Pageable pageable);
}
