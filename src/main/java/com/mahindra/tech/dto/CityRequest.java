package com.mahindra.tech.dto;

import com.mahindra.tech.entities.Country;

public record CityRequest (
        String name,
        Long countryId
) {}
