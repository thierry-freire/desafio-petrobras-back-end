package com.challenges.desafiopetrobrasbackend.controller;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.services.EventosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventosController {
    private final EventosService eventosService;

    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }

    @GetMapping("/events")
    public ResponseEntity<Page<Eventos>> listar (Pageable pageable){
        return ResponseEntity.ok(eventosService.listar(pageable));
    }
}
