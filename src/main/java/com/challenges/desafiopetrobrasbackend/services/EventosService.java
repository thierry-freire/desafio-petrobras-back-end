package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import com.challenges.desafiopetrobrasbackend.model.Eventos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EventosService {
    Page<EventosDTO> list(Pageable pageable);

    EventosDTO getOne(Long id);

    EventosDTO update(Long id, EventosDTO updateInfo);

    void save(Eventos evento);
}
