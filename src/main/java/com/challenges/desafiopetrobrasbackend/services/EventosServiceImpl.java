package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.repository.EventosRepository;

public class EventosServiceImpl implements EventosService {
    private final EventosRepository eventosRepository;

    public EventosServiceImpl(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @Override
    public void save(Eventos evento) {
        eventosRepository.save(evento);
    }
}
