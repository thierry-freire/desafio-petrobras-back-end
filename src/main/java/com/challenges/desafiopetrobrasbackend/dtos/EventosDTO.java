package com.challenges.desafiopetrobrasbackend.dtos;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Título é obrigatório")
    @Size(max = 100)
    private String titulo;

    @NotBlank(message = "Descrição é obrigatório")
    @Size(max = 1000)
    private String descricao;

    @NotNull(message = "Data é obrigatório")
    @Future(message = "A data deve ser futura")
    private Date data;

    @NotBlank(message = "Local é obrigatório")
    @Size(max = 200)
    private String local;

    public EventosDTO (Eventos evento) {
        this.id = evento.getId();
        this.titulo = evento.getTitulo();
        this.descricao = evento.getDescricao();
        this.data = evento.getData();
        this.local = evento.getLocal();
    }
}
