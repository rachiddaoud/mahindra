package com.mahindra.tech.service;

import com.mahindra.tech.dto.CityRequest;
import com.mahindra.tech.dto.CityResponse;
import com.mahindra.tech.entities.City;
import com.mahindra.tech.entities.Country;
import com.mahindra.tech.repositories.CityRepository;
import com.mahindra.tech.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    CityRepository cityRepository;
    CountryRepository countryRepository;
    public CityService(
            CityRepository cityRepository,
            CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public List<CityResponse> findAll() {
        return cityRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CityResponse add(CityRequest cityRequest) {
        City city = new City();
        city.setName(cityRequest.name());
        Country country = countryRepository.findById(cityRequest.countryId()).orElseThrow(() -> new RuntimeException("Country not found"));
        city.setCountry(country);
        return mapToResponse(cityRepository.save(city));
    }

    private CityResponse mapToResponse(City city) {
        return new CityResponse(
                city.getId(),
                city.getName()
        );
    }

    public List<CityResponse> getCitiesByCountry(Long countryId) {
        return cityRepository.findByCountryId(countryId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}
