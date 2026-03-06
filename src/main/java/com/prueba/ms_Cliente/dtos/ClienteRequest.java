package com.prueba.ms_Cliente.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ClienteRequest implements Serializable {
    @NotNull
    @JsonProperty("idcliente")
    private Integer id;
    @NotNull
    @Pattern(regexp = "^[A-Za-z]{1,255}$")
    private String nombre;
    @NotNull
    @Pattern(regexp = "^[A-Za-z]{1,255}$")
    private String apellido;
    private Boolean estado;
    @NotNull
    private Integer edad;
}
