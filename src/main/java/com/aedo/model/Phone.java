package com.aedo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import com.aedo.model.Usuario;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String number;

    @Column
    private String citycode;

    @Column
    private String contrycode;

    @Column(name = "usuario_id")
    private String usuarioId;

    public Phone() {}

    public Phone(String number, String citycode, String contrycode, String usuarioId) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
        this.usuarioId = usuarioId;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Phone{" +
                " number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", contrycode='" + contrycode + '\'' +
                '}';
    }


}
