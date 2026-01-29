package com.mcpserver.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
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
    @Tool(description = "Get the weather for a specific lon/lat")
    public String getWeatherForecastByLocation(String lon, String lat){
        HttpHeaders headers = new HttpHeaders();
        //to do write the api call
        return "";
    }
    @Tool(description = "Get weather alerts for a US state")
    public String getAlerts(
            @ToolParam(description = "Two-letter US state code (e.g. CA, NY)") String state
    ) {
        // Returns active alerts including:
        // - Event type
        // - Affected area
        // - Severity
        // - Description
        // - Safety instructions
        return "";
    }
}
