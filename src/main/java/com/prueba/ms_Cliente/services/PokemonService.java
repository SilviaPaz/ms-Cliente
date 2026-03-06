package com.prueba.ms_Cliente.services;

import reactor.core.publisher.Mono;

public interface PokemonService {

    Mono<String> listarDito();
}
