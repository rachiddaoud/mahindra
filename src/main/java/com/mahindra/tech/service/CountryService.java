package com.mahindra.tech.service;

import com.mahindra.tech.dto.CountryRequest;
import com.mahindra.tech.dto.CountryResponse;
import com.mahindra.tech.entities.Country;
import com.mahindra.tech.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponse> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CountryResponse add(CountryRequest countryRequest) {
        Country country = new Country();
        country.setName(countryRequest.name());
        return mapToResponse(countryRepository.save(country));
    }

    private CountryResponse mapToResponse(Country country) {
        return new CountryResponse(
                country.getId(),
                country.getName()
        );
    }
}
