package com.mcpserver.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {
    private final RestClient restClient;
    public WeatherService() {
        this.restClient=RestClient.builder()
                .baseUrl("https://api.weather.gov")
                .defaultHeader("Accept","Application/geo+json")
                .defaultHeader("User-agent","WeatherApiClient/1.0 hei.marc.3@gmail.com")
                .build();
    }
}
