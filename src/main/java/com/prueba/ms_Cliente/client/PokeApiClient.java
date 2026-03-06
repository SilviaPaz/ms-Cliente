package com.prueba.ms_Cliente.client;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PokeApiClient {

    private final WebClient webClient;

    public PokeApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://pokeapi.co/api/v2")
                .build();
    }

    public Mono<String> getPokemonDitto() {
        return webClient.get()
                .uri("/pokemon/ditto")
                .retrieve()
                .bodyToMono(String.class);
    }

    public static void main(String[] args) {
        PokeApiClient client = new PokeApiClient();
        client.getPokemonDitto();
    }
}