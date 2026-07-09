package com.challenges.desafiopetrobrasbackend.controller;

import com.challenges.desafiopetrobrasbackend.services.EventosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventosController {
    private final EventosService eventosService;

    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }


}
