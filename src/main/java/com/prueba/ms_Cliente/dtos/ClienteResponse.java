package com.prueba.ms_Cliente.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse implements Serializable {
    @JsonProperty("idCliente")
    private Integer id;
    private String nombre;
    private String apellido;
    private Boolean estado;
    private Integer edad;
}
