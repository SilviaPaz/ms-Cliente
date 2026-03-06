package com.prueba.ms_Cliente.services;

import com.prueba.ms_Cliente.dtos.ClienteRequest;
import com.prueba.ms_Cliente.dtos.ClienteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    public Mono<ClienteResponse> crearCliente(ClienteRequest clienteRequest);
    public Flux<ClienteResponse> listarClientesActivos();
    public Mono<ClienteResponse> modificarCliente(ClienteRequest clienteRequest);
    public Mono<ClienteResponse> eliminarCliente(ClienteRequest clienteRequest);
}
