package com.challenges.desafiopetrobrasbackend.repository;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Eventos, Integer> {
    Page<Eventos> findAllByDeleted(String deleted, Pageable pageable);
}
