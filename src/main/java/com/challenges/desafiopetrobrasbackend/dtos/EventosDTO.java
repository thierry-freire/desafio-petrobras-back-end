package com.challenges.desafiopetrobrasbackend.dtos;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventosDTO {
    private Long id;

    private String titulo;

    private String descricao;

    private Date data;

    private String local;

    public EventosDTO (Eventos evento) {
        this.id = evento.getId();
        this.titulo = evento.getTitulo();
        this.descricao = evento.getDescricao();
        this.data = evento.getData();
        this.local = evento.getLocal();
    }
}
