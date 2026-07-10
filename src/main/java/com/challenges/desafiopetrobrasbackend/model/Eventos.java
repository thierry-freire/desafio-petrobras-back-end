package com.challenges.desafiopetrobrasbackend.model;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eventos")
public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long id;

    @Column(name = "titulo_evento")
    private String titulo;

    @Column(name = "descricao_evento")
    private String descricao;

    @Column(name = "data_evento")
    private Date data;

    @Column(name = "local_evento")
    private String local;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted")
    private String deleted;

    public Eventos (EventosDTO eventoDTO) {
        this.titulo = eventoDTO.getTitulo();
        this.descricao = eventoDTO.getDescricao();
        this.data = eventoDTO.getData();
        this.local = eventoDTO.getLocal();
    }
}
