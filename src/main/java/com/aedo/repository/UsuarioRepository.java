package com.aedo.repository;

import com.aedo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
}