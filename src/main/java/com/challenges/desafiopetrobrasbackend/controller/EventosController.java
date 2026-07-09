package com.challenges.desafiopetrobrasbackend.controller;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.services.EventosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<EventosDTO>> list (@RequestParam Pageable pageable){
        return ResponseEntity.ok(eventosService.list(pageable));
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventosDTO> getOne (@RequestParam Long id) {
        return ResponseEntity.ok(eventosService.getOne(id));
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<EventosDTO> update (@RequestParam Long id, @RequestBody EventosDTO updateInfo) {
        return ResponseEntity.ok(eventosService.update(id, updateInfo));
    }

    @PostMapping("/events")
    public ResponseEntity<EventosDTO> save (@RequestBody Eventos evento) {
        eventosService.save(evento);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<EventosDTO> delete (@RequestParam Long id) {
        eventosService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
