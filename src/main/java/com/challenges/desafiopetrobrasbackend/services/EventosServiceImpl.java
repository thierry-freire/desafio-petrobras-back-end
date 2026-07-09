package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.repository.EventosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EventosServiceImpl implements EventosService {
    private final EventosRepository eventosRepository;

    public EventosServiceImpl(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @Override
    public Page<Eventos> listar(Pageable pageable) {
        return eventosRepository.findAll(pageable);
    }

    @Override
    public void save(Eventos evento) {
        eventosRepository.save(evento);
    }
}
