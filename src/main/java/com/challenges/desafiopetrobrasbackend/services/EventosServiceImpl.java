package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import com.challenges.desafiopetrobrasbackend.exceptions.ResourceNotFoundException;
import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.repository.EventosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class EventosServiceImpl implements EventosService {
    private final EventosRepository eventosRepository;

    public EventosServiceImpl(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @Override
    public Page<EventosDTO> list(Pageable pageable) {
        return eventosRepository.findAllByDeleted("N", pageable).map(EventosDTO::new);
    }

    @Override
    public EventosDTO getOne(Long id) {
        return new EventosDTO(eventosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado.")));
    }

    @Override
    public EventosDTO update(Long id, EventosDTO updateInfo) {
        Eventos evento = eventosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado."));
        evento.setDescricao(updateInfo.getDescricao());
        evento.setTitulo(updateInfo.getTitulo());
        evento.setData(updateInfo.getData());
        evento.setLocal(updateInfo.getLocal());
        evento.setUpdatedAt(Date.from(Instant.now()));

        return new EventosDTO(eventosRepository.save(evento));
    }

    @Override
    public void save(EventosDTO evento) {
        eventosRepository.save(new Eventos(evento));
    }

    @Override
    public void delete(Long id) {
        Eventos evento = eventosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado."));
        evento.setDeleted("S");
        evento.setUpdatedAt(Date.from(Instant.now()));

        eventosRepository.save(evento);
    }
}
