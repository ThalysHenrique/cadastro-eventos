package com.eventoapp.eventoapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rg;
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

}
