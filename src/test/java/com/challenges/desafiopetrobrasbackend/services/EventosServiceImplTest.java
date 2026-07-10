package com.challenges.desafiopetrobrasbackend.services;

import com.challenges.desafiopetrobrasbackend.dtos.EventosDTO;
import com.challenges.desafiopetrobrasbackend.exceptions.ResourceNotFoundException;
import com.challenges.desafiopetrobrasbackend.model.Eventos;
import com.challenges.desafiopetrobrasbackend.repository.EventosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventosServiceImplTest {

    @Mock
    private EventosRepository eventosRepository;

    @InjectMocks
    private EventosServiceImpl eventosService;

    @Test
    void update_deveAtualizarEventoQuandoIdExistir() {
        Eventos eventoExistente = evento(1L, "Titulo antigo", "Descricao antiga", "Local antigo");
        EventosDTO atualizacao = new EventosDTO(1L, "Titulo novo", "Descricao nova", dataFutura(), "Local novo");
        when(eventosRepository.findById(1L)).thenReturn(Optional.of(eventoExistente));
        when(eventosRepository.save(eventoExistente)).thenReturn(eventoExistente);

        EventosDTO resultado = eventosService.update(1L, atualizacao);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getTitulo()).isEqualTo("Titulo novo");
        assertThat(resultado.getDescricao()).isEqualTo("Descricao nova");
        assertThat(resultado.getLocal()).isEqualTo("Local novo");
        assertThat(resultado.getData()).isEqualTo(atualizacao.getData());
        assertThat(eventoExistente.getUpdatedAt()).isNotNull();
        verify(eventosRepository).save(eventoExistente);
    }

    @Test
    void delete_deveLancarExcecaoQuandoEventoNaoExistir() {
        when(eventosRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> eventosService.delete(99L))
                .isInstanceOf(ResourceNotFoundException.class);

        verify(eventosRepository, never()).save(org.mockito.ArgumentMatchers.any(Eventos.class));
    }

    private Eventos evento(Long id, String titulo, String descricao, String local) {
        return new Eventos(id, titulo, descricao, dataFutura(), local, new Date(), null, "N");
    }

    private Date dataFutura() {
        return Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
    }
}
