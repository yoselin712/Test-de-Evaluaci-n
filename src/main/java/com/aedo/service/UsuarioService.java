package com.aedo.service;

import com.aedo.model.Usuario;

public interface UsuarioService {
    /**
     * Obtiene usuario segun el mail
     * @param email
     * @return
     */
    Usuario getUsuarioByEmail(String email);

    /**
     * Consulta si el email existe en la BD
     * @param email
     * @return
     */
    boolean existeUsuarioByEmail(String email);
    /**
     * Valida que el exista el email y el password sea el mismo del input
     * (Requiere encriptacion de datos)
     * @param email
     * @param password
     * @return
     */
    Usuario validateUser(String email, String password);

    /**
     * Guarda el usuario
     * @param usuario
     */
    Usuario saveUsuario(Usuario usuario);
}
