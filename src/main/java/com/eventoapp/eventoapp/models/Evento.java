package com.eventoapp.eventoapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    private String nome;
    private String local;
    private String data;
    private String horario;

    @OneToMany
    private List<Convidado> convidados;
}
