package com.prueba.ms_Cliente.handlers;

import com.prueba.ms_Cliente.dtos.ClienteResponse;
import com.prueba.ms_Cliente.services.ClienteService;
import com.prueba.ms_Cliente.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PokemonHandler {

    private final PokemonService pokemonService;

    public Mono<ServerResponse> listAll(ServerRequest serverRequest) {
        Mono<String> pokemonResponse = pokemonService.listarDito();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(pokemonResponse, String.class);
    }
}
