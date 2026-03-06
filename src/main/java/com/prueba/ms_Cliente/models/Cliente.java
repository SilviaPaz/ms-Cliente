package com.prueba.ms_Cliente.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {
    @Id
    private Integer id;

    private Integer idcliente;
    private String nombre;
    private String apellido;
    private Boolean estado;
    private Integer edad;
}
