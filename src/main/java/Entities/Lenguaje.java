package Entities;

import java.util.ArrayList;
import java.util.List;

public class Lenguaje {

    private String nombre;

    private List<String> usuarios;

    public Lenguaje(String nombre) {
        this.nombre = nombre;
        usuarios = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getUsuarios() {
        return usuarios;
    }



    @Override
    public String toString() {
        return "Entities.Lenguaje{" +
                "nombre='" + nombre + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
