package com.biblioteca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.modelo.LibroEntidad;

@Repository
public interface LibroRepositorio extends JpaRepository<LibroEntidad, Long> {

}
