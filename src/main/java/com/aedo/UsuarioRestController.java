package com.aedo;

import com.aedo.domain.Phones;
import com.aedo.domain.StatusInfo;
import com.aedo.domain.UsuarioRequest;
import com.aedo.model.Phone;
import com.aedo.model.JwtUser;
import com.aedo.model.Usuario;
import com.aedo.service.JwtService;
import com.aedo.service.PhoneService;
import com.aedo.service.UsuarioService;
import com.aedo.utils.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Repository
@RestController
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private JwtService jwtService;

    /**
     * Request para Login de usuario y obtención de Token (JWT)
     * @param userRequest {"email" : "XXXXX@gmail.com" ,"password" : "XXXXX"}
     * @return ResponseEntity
     */
    @PostMapping(value = "/Login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> login(@RequestBody UsuarioRequest userRequest) {

        try {
            String email = userRequest.getEmail();
            String password = userRequest.getPassword();

            Assert.notNull(email, "Ingrese email");
            Assert.notNull(password, "Ingrese password");

            //Validamos que exista el correo
            if(!usuarioService.existeUsuarioByEmail(email))
                return new ResponseEntity<>(new StatusInfo(HttpStatus.BAD_REQUEST.value(),
                        "El correo no se ha registrado."), HttpStatus.BAD_REQUEST);

            //Autenticamos el usuario
            Usuario userValidado = usuarioService.validateUser(email, password);

            if(userValidado != null){
                //Obtenemos token
                JwtUser jwtUser = new JwtUser(email, password);
                String token = jwtService.getToken(jwtUser);

                //Actualizamos el last_login y token
                userValidado.setLast_login(new Date());
                userValidado.setToken(token);
                usuarioService.saveUsuario(userValidado);

                return ResponseEntity.ok( new StatusInfo(HttpStatus.OK.value(), "Datos de acceso correcto.", token));
            }

            return new ResponseEntity<>(new StatusInfo(HttpStatus.UNAUTHORIZED.value(), "Datos de acceso erroneos."), HttpStatus.UNAUTHORIZED);

        }catch (Exception e){
            return new ResponseEntity<>(new StatusInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Request para creacion de usuario. Requiere x-auth-token obtenido en /Login
     * @param userRequest {"name" : "Juan Rodriguez","email" : "juasaan@rodriguez.org","password" : "Fhunter112" ,"phones" : [{"number" : "1234567" ,"citycode" : "1" ,"contrycode" : "57"}]}
     * @return ResponseEntity
     */
    @PostMapping(value="/Usuario", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioRequest userRequest) {
        try {
            Assert.notNull(userRequest.getEmail(), "Ingrese email");
            Assert.notNull(userRequest.getPassword(), "Ingrese password");
            Assert.notNull(userRequest.getName(), "Ingrese nombre");

            //Validar que el email sea correcto
            if(!Utilidades.validarInput(userRequest.getEmail(), Utilidades.EMAIL_REGEX))
                throw new Exception("Formato de email no correcto.");

            //Validar que la password sea correcta
            if(!Utilidades.validarInput(userRequest.getPassword(), Utilidades.PASSWORD_REGEX))
                throw new Exception("Formato de password no correcto.");

            //Validar si el email existe
           if(usuarioService.existeUsuarioByEmail(userRequest.getEmail()))
               throw new Exception("El correo ya registrado");

            //Creamos token para el nuevo usuario
            JwtUser jwtUser = new JwtUser(userRequest.getEmail(), userRequest.getPassword());
            String token = jwtService.getToken(jwtUser);

            //Creamos el usuario y lo guardamos
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setEmail(userRequest.getEmail());
            nuevoUsuario.setName(userRequest.getName());
            nuevoUsuario.setPassword(userRequest.getPassword());

            nuevoUsuario.setToken(token);
            nuevoUsuario.setIsactive(1);
            nuevoUsuario.setCreated(new Date());
            nuevoUsuario.setLast_login(new Date());

            nuevoUsuario = usuarioService.saveUsuario(nuevoUsuario);
            if(!userRequest.getPhones().isEmpty()){
                Set<Phone> listaPhones = new HashSet<>();
                for (Phones ph : userRequest.getPhones()) {
                    Assert.notNull(ph.getNumber(), "Ingrese número");
                    Assert.notNull(ph.getCitycode(), "Ingrese city code");
                    Assert.notNull(ph.getContrycode(), "Ingrese contry code");
                    Phone phone = new Phone();
                    phone.setContrycode(ph.getContrycode());
                    phone.setNumber(ph.getNumber());
                    phone.setCitycode(ph.getCitycode());
                    phone.setUsuarioId(nuevoUsuario.getId());
                    listaPhones.add(phone);
                }
                phoneService.savePhones(listaPhones);
            }

            return ResponseEntity.ok( new StatusInfo(HttpStatus.OK.value(), "Creado Correctamente.", nuevoUsuario));
        }catch (Exception e){
            return new ResponseEntity<>(new StatusInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}