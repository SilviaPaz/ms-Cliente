package com.prueba.ms_Cliente.repository;

import com.prueba.ms_Cliente.models.Cliente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends R2dbcRepository<Cliente, Integer> {

    Mono<Cliente> findByIdcliente(Integer idcliente);

    Flux<Cliente> findByEstado(Boolean estado);
}