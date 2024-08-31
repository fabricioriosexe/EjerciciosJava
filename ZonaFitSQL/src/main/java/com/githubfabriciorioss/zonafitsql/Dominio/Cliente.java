package com.githubfabriciorioss.zonafitsql.Dominio;

import java.util.Objects;

/*
 * * CREAMOS EL MODELO DE CLIENTE PARA EL MODELO DE SQL
 */

public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String membresia;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nombre, String apellido, String membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    public Cliente(int id, String nombre, String apellido, String membresia) {
        this(nombre, apellido, membresia);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", membresia=" + membresia + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.membresia != other.membresia) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }

}
