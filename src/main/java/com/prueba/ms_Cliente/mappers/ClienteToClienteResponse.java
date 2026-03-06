package com.prueba.ms_Cliente.mappers;

import com.prueba.ms_Cliente.dtos.ClienteResponse;
import com.prueba.ms_Cliente.models.Cliente;

public class ClienteToClienteResponse {

    public static ClienteResponse toClienteResponse(Cliente cliente) {
        return ClienteResponse.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .estado(cliente.getEstado())
                .edad(cliente.getEdad()).build();
    }
}
