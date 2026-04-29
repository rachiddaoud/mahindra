package com.mahindra.tech.controller;

import com.mahindra.tech.dto.CityResponse;
import com.mahindra.tech.dto.CountryRequest;
import com.mahindra.tech.dto.CountryResponse;
import com.mahindra.tech.service.CityService;
import com.mahindra.tech.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    CountryService countryService;
    CityService cityService;

    public CountryController(
            CountryService countryService,
            CityService cityService
    ) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping
    public List<CountryResponse> getCountries() {
        return countryService.findAll();
    }

    @PostMapping
    public CountryResponse addCountry(@RequestBody CountryRequest countryRequest) {
        return countryService.add(countryRequest);
    }

    @GetMapping("/{countryId}/cities")
    public Page<CityResponse> getCities(@PathVariable("countryId") Long countryId, Pageable pageable) {
        return cityService.getCitiesByCountry(countryId, pageable);
    }
}
