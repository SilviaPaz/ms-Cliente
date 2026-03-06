package com.prueba.ms_Cliente.mappers;

import com.prueba.ms_Cliente.dtos.ClienteRequest;
import com.prueba.ms_Cliente.models.Cliente;

public class ClienteRequestToCliente {

    public static Cliente toCliente(ClienteRequest clienteRequest){
        return Cliente.builder()
                .idcliente(clienteRequest.getId())
                .nombre(clienteRequest.getNombre())
                .apellido(clienteRequest.getApellido())
                .edad(clienteRequest.getEdad())
                .estado(clienteRequest.getEstado()).build();
    }
}
