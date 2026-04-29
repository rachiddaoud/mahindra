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

    @GetMapping("/{id}")
    public CityResponse getCity(@PathVariable("id") Long id) {
        return cityService.getCity(id);
    }

    @PostMapping
    public CityResponse addCity(@RequestBody CityRequest CityRequest) {
        return cityService.add(CityRequest);
    }
}
