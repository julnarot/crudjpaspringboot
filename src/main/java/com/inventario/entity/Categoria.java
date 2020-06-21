package com.inventario.entity;

import javax.persistence.*;

@Entity
@Table(name = "app_categoria")
public class Categoria {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
}
