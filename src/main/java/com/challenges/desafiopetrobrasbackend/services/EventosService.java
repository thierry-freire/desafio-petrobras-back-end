package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EventosService {
    Page<Eventos> listar(Pageable pageable);

    void save(Eventos evento);
}
