package com.challenges.desafiopetrobrasbackend.controller;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.services.EventosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventosController {
    private final EventosService eventosService;

    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }

    @GetMapping("/events")
    public ResponseEntity<Page<EventosDTO>> listar (Pageable pageable){
        return ResponseEntity.ok(eventosService.listar(pageable));
    }

    @PostMapping("/events")
    public ResponseEntity<Eventos> save (@RequestBody Eventos evento) {
        eventosService.save(evento);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }
}
