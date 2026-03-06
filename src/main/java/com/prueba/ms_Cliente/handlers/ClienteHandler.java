package com.prueba.ms_Cliente.handlers;

import com.prueba.ms_Cliente.Validations.ObjectValidator;
import com.prueba.ms_Cliente.dtos.ClienteRequest;
import com.prueba.ms_Cliente.dtos.ClienteResponse;
import com.prueba.ms_Cliente.services.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class ClienteHandler {

    private final ClienteService clienteService;

    private final ObjectValidator objectValidator;

    private static final Logger LOG = LoggerFactory.getLogger(ClienteHandler.class);

    public Mono<ServerResponse> listAll(ServerRequest serverRequest) {
        Flux<ClienteResponse> clienteResponseFlux = clienteService.listarClientesActivos();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(clienteResponseFlux, ClienteResponse.class);
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        Mono<ClienteRequest> clienteRequestMono = serverRequest.bodyToMono(ClienteRequest.class)
                .doOnNext(objectValidator::validate);
        return clienteRequestMono.flatMap(cli -> ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.crearCliente(cli), ClienteResponse.class)
        );
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        Mono<ClienteRequest> clienteRequestMono = serverRequest.bodyToMono(ClienteRequest.class)
                .doOnNext(objectValidator::validate);
        return clienteRequestMono.flatMap(cli -> ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.modificarCliente(cli), ClienteResponse.class)
        );
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        Mono<ClienteRequest> clienteRequestMono = serverRequest.bodyToMono(ClienteRequest.class)
                .doOnNext(objectValidator::validate);
        return clienteRequestMono.flatMap(cli -> ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.eliminarCliente(cli), ClienteResponse.class)
        );
    }
}
