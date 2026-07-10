package com.challenges.desafiopetrobrasbackend.repository;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = "spring.jpa.hibernate.ddl-auto=update")
@Testcontainers
@DisabledInAotMode
class EventosRepositoryIntegrationTest {

    @Container
    static final MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:8.4");

    @Autowired
    private EventosRepository eventosRepository;

    @DynamicPropertySource
    static void configureDataSource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MYSQL::getJdbcUrl);
        registry.add("spring.datasource.username", MYSQL::getUsername);
        registry.add("spring.datasource.password", MYSQL::getPassword);
    }

    @Test
    @Transactional
    void findAllByDeleted_deveRetornarApenasEventosNaoExcluidos() {
        eventosRepository.save(evento("Evento ativo", "N"));
        eventosRepository.save(evento("Evento excluido", "S"));

        Page<Eventos> eventosAtivos = eventosRepository.findAllByDeleted("N", PageRequest.of(0, 10));

        assertThat(eventosAtivos).hasSize(1);
        assertThat(eventosAtivos.getContent().getFirst().getTitulo()).isEqualTo("Evento ativo");
        assertThat(eventosAtivos.getContent().getFirst().getDeleted()).isEqualTo("N");
    }

    private Eventos evento(String titulo, String deleted) {
        Date agora = new Date();
        return new Eventos(null, titulo, "Descricao", Date.from(Instant.now().plus(1, ChronoUnit.DAYS)),
                "Rio de Janeiro", agora, agora, deleted);
    }
}
