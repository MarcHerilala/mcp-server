# MCP Movie Server

## Description
This is a learning project that demonstrates how to build a Model Context Protocol (MCP) server using **Spring AI**.

It exposes tools to interact with the **OMDB API**, allowing you to retrieve movie and series information.

## Features
- **Get Movie by Title**: Retrieve detailed information about a specific movie or series.
- **Search Movies**: Search for multiple movies or series using keywords.

## Technologies Used
- Java 21
- Spring Boot 3.x
- Spring AI (MCP Server)
- OMDB API

## Configuration
To run this project, you need to provide an OMDB API key in your configuration (e.g., `application.properties` or environment variables):

```properties
omdb.api.key=YOUR_API_KEY
```

## Tools
The server exposes the following tools:
- `getMovieByTitle`: Retrieve film or series information by title.
- `searchMovies`: Search for movies/series by keyword.
