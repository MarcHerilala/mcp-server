package com.mcpserver.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class MovieService {
    private final RestClient restClient;
    private  String apiKey ;;
    public MovieService(@Value("${omdb.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.restClient=RestClient.builder()
                .baseUrl("https://www.omdbapi.com")
                .defaultHeader("Accept","Application/json")
                .build();
    }
    @Tool(description = "Retrieve film or serie information by titles")
    public String getMovieByTitle(
            @ToolParam(description = "Titre du film ou de la série") String title
    ) {
        try {
            String url = String.format("/?apikey=%s&t=%s", apiKey, title.replace(" ", "+"));
            return restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(String.class);
        } catch (RestClientException e) {
            return "{\"error\":\"Impossible de récupérer les données\"}";
        }
    }

    @Tool(description = "Recherche plusieurs films ou séries par mot clé")
    public String searchMovies(
            @ToolParam(description = "Mot clé pour la recherche") String keyword
    ) {
        try {
            String url = String.format("/?apikey=%s&s=%s", apiKey, keyword.replace(" ", "+"));
            return restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(String.class)
                    ;

        } catch (RestClientException e) {
            return "{\"error\":\"Impossible de récupérer les résultats\"}";
        }
    }
}
