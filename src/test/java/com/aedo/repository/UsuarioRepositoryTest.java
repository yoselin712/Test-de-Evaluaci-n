package com.aedo.repository;

import com.aedo.model.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    public void findByEmail() {
        Usuario usuarioBase = usuarioRepository.findByEmail("yoselin.aedo@gmail.com");
        Assertions.assertThat(usuarioBase.getName())
                .isEqualTo("Yoselin Aedo");
    }
}