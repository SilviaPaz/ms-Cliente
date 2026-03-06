package com.prueba.ms_Cliente.routers;

import com.prueba.ms_Cliente.handlers.ClienteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class ClienteRouter {

    private static final String PATH= "api/v1/cliente";

    @Bean
    public WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }

    @Bean
    RouterFunction<ServerResponse> router(ClienteHandler handler) {
        return RouterFunctions.route()
                .GET(PATH, handler::listAll)
                .POST(PATH, handler::create)
                .DELETE(PATH, handler::delete)
                .PUT(PATH, handler::update)
                .build();
    }
}
