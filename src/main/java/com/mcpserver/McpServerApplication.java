package com.mcpserver;

import com.mcpserver.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
   /* @Bean
    ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }*/
   @Bean
   CommandLineRunner testMovieService(MovieService movieService) {
       return args -> {
           System.out.println("=== Test getMovieByTitle ===");
           String movie = movieService.getMovieByTitle("Inception");
           System.out.println(movie);

           System.out.println("=== Test searchMovies ===");
           String search = movieService.searchMovies("Star Wars");
           System.out.println(search);
       };
   }
}
