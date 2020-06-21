package com.inventario.entity;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name = "app_producto")
public class Producto {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    private Long categoriaId;
    /*@ManyToMany
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;*/




}
