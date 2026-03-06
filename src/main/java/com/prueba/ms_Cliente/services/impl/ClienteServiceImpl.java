package com.prueba.ms_Cliente.services.impl;

import com.prueba.ms_Cliente.dtos.ClienteRequest;
import com.prueba.ms_Cliente.dtos.ClienteResponse;
import com.prueba.ms_Cliente.exceptions.CustomException;
import com.prueba.ms_Cliente.mappers.ClienteRequestToCliente;
import com.prueba.ms_Cliente.mappers.ClienteToClienteResponse;
import com.prueba.ms_Cliente.repository.ClienteRepository;
import com.prueba.ms_Cliente.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    private static final String NO_EXISTE = "Cliente no existe";
    private static final String YA_EXISTE = "Cliente ya existe";

    @Override
    public Mono<ClienteResponse> crearCliente(ClienteRequest clienteRequest) {
        Mono<Boolean> clienteExiste = clienteRepository.findByIdcliente(clienteRequest.getId()).hasElement();

        return clienteExiste.flatMap(
                exist -> exist ?
                Mono.error(new CustomException(HttpStatus.BAD_REQUEST, YA_EXISTE))
                : clienteRepository.save(ClienteRequestToCliente.toCliente(clienteRequest))
        .flatMap(t -> Mono.empty())
        );
    }

    @Override
    public Flux<ClienteResponse> listarClientesActivos(){
        return clienteRepository.findByEstado(true)
                .switchIfEmpty(Flux.error(new CustomException(HttpStatus.BAD_REQUEST, NO_EXISTE)))
                .map(cl -> ClienteResponse.builder()
                        .id(cl.getIdcliente())
                        .nombre(cl.getNombre())
                        .apellido(cl.getApellido())
                        .edad(cl.getEdad())
                        .estado(cl.getEstado())
                        .build());
    }

    @Override
    public Mono<ClienteResponse> modificarCliente(ClienteRequest clienteRequest) {
        Mono<Boolean> clienteExiste = clienteRepository.findByIdcliente(clienteRequest.getId()).hasElement();

        return clienteExiste.flatMap(
                exist -> !exist ?
                        Mono.error(new CustomException(HttpStatus.BAD_REQUEST, NO_EXISTE))
                        : clienteRepository.findByIdcliente(clienteRequest.getId())
                        .flatMap(cl -> {
                            cl.setNombre(clienteRequest.getNombre());
                            cl.setApellido(clienteRequest.getApellido());
                            cl.setEdad(clienteRequest.getEdad());
                            cl.setEstado(clienteRequest.getEstado());
                            return clienteRepository.save(cl);
                        })
                        .map(ClienteToClienteResponse::toClienteResponse)
        );
    }

    @Override
    public Mono<ClienteResponse> eliminarCliente(ClienteRequest clienteRequest){
        Mono<Boolean> clienteExiste = clienteRepository.findByIdcliente(clienteRequest.getId()).hasElement();

        return clienteExiste.flatMap(
                exist -> !exist ?
                        Mono.error(new CustomException(HttpStatus.BAD_REQUEST, NO_EXISTE))
                        : clienteRepository.deleteById(ClienteRequestToCliente.toCliente(clienteRequest).getIdcliente())
                        .flatMap(cl -> Mono.empty())
        );
    }
}
