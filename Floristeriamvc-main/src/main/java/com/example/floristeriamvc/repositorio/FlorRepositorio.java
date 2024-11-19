package com.example.floristeriamvc.repositorio;

import com.example.floristeriamvc.modelo.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepositorio extends JpaRepository<Flor, Long> {
}
