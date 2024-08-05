package com.project.backend.config;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EpicGamesApiClient {

    private final RestTemplate restTemplate;
    private final String url;

    public EpicGamesApiClient() {
        this.restTemplate = new RestTemplate();
        this.url = "https://www.epicgames.com/store/en-US/new-releases";
    }

    public String fetchData() {
        return restTemplate.getForObject(url, String.class);
    }
}
