package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.repository.EventosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventosServiceImpl implements EventosService {
    private final EventosRepository eventosRepository;

    public EventosServiceImpl(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @Override
    public Page<EventosDTO> list(Pageable pageable) {
        return eventosRepository.findAll(pageable).map(EventosDTO::new);
    }

    @Override
    public EventosDTO getOne(Long id) {
        return new EventosDTO(eventosRepository.getReferenceById(id.intValue()));
    }

    @Override
    public void save(Eventos evento) {
        eventosRepository.save(evento);
    }
}
