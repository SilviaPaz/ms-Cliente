package com.prueba.ms_Cliente.routers;

import com.prueba.ms_Cliente.handlers.PokemonHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class PokemonRouter {

    private static final String PATH= "api/v1/pokemon";

    @Bean
    RouterFunction<ServerResponse> routerPokemon(PokemonHandler handler) {
        return RouterFunctions.route()
                .GET(PATH, handler::listAll)
                .build();
    }
}
