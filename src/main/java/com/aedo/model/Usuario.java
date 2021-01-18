package com.aedo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date created;

    @Column
    private Date modified;

    @Column
    private Date last_login;

    @Column
    private String token;

    @Column
    private int isactive;

    public Usuario() {
    }

    public Usuario(String id, String name, String email, String password, Date created, Date modified, Date last_login, String token, int isactive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.isactive = isactive;
    }

    public String getId() {
            return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int active) {
        this.isactive = active;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", last_login=" + last_login +
                ", token='" + token + '\'' +
                ", isactive=" + isactive +
                '}';
    }
}
