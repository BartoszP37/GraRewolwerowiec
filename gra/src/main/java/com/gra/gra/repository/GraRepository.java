package com.gra.gra.repository;

import com.gra.gra.parts.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraRepository extends JpaRepository<Game, Long> {

}
