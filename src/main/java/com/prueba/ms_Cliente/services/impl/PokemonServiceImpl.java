package com.prueba.ms_Cliente.services.impl;

import com.prueba.ms_Cliente.client.PokeApiClient;
import com.prueba.ms_Cliente.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    PokeApiClient pokeApiClient;

    @Override
    public Mono<String> listarDito(){
        return pokeApiClient.getPokemonDitto();
    }
}
