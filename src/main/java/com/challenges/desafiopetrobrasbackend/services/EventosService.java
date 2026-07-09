package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import org.springframework.stereotype.Service;

@Service
public interface EventosService {
    void save(Eventos evento);
}
