package com.eventoapp.eventoapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer rg;
    @NotEmpty
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

}
