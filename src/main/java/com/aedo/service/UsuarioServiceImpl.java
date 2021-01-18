package com.aedo.service;

import com.aedo.model.Usuario;
import com.aedo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Obtiene usuario segun el mail
     * @param email
     * @return
     */
    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Consulta si el email existe en la BD
     * @param email
     * @return
     */
    public boolean existeUsuarioByEmail(String email) {
        return this.getUsuarioByEmail(email) != null;
    }

    /**
     * Valida que el exista el email y el password sea el mismo del input
     * (Requiere encriptacion de datos)
     * @param email
     * @param password
     * @return
     */
    public Usuario validateUser(String email, String password) {
        Usuario user = this.getUsuarioByEmail(email);
        if(user != null && user.getPassword().equals(password))
            return user;
        return null;
    }

    /**
     * Guarda el usuario
     * @param usuario
     */
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}