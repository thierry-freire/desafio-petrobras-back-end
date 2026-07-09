package com.challenges.desafiopetrobrasbackend.repository;

import com.challenges.desafiopetrobrasbackend.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Eventos, Integer> {
}
