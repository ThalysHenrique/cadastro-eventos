package com.eventoapp.eventoapp.repositories;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoRepository extends JpaRepository<Convidado, Integer> {

    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(Integer rg);
}
