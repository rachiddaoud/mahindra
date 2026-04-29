package com.mahindra.tech.controller;

import com.mahindra.tech.dto.CityResponse;
import com.mahindra.tech.dto.CityRequest;
import com.mahindra.tech.dto.CityResponse;
import com.mahindra.tech.service.CityService;
import com.mahindra.tech.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    CityService cityService;

    public CityController(
            CityService cityService
    ) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityResponse> getCountries() {
        return cityService.findAll();
    }

    @PostMapping
    public CityResponse addCity(@RequestBody CityRequest CityRequest) {
        return cityService.add(CityRequest);
    }
}
