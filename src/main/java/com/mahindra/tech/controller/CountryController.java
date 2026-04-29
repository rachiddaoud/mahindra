package com.mahindra.tech.controller;

import com.mahindra.tech.dto.CityResponse;
import com.mahindra.tech.dto.CountryRequest;
import com.mahindra.tech.dto.CountryResponse;
import com.mahindra.tech.service.CityService;
import com.mahindra.tech.service.CountryService;
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
    public List<CityResponse> getCities(@PathVariable("countryId") Long countryId) {
        return cityService.getCitiesByCountry(countryId);
    }
}
