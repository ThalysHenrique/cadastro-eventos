package com.eventoapp.eventoapp.controllers;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repositories.ConvidadoRepository;
import com.eventoapp.eventoapp.repositories.EventoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    final private EventoRepository eventoRepository;

    final private ConvidadoRepository convidadoRepository;

    public EventoController(EventoRepository eventoRepository, ConvidadoRepository convidadoRepository) {
        this.eventoRepository = eventoRepository;
        this.convidadoRepository = convidadoRepository;
    }

    @RequestMapping(value ="/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value ="/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento){
        eventoRepository.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = eventoRepository.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable(value = "codigo") long codigo){
        Evento evento = eventoRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);
        System.out.println("evento " + evento);
        Iterable<Convidado> convidados = convidadoRepository.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String adicionarConvidado(@PathVariable(value = "codigo") long codigo, Convidado convidado){
        Evento evento = eventoRepository.findByCodigo(codigo);
        convidado.setEvento(evento);
        convidadoRepository.save(convidado);
        return "redirect:/{codigo}";
    }
}
