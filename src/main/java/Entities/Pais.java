package Entities;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private String nombre;

    List<String> alumnos = new ArrayList();
    List<String> ciudades = new ArrayList();

    public Pais(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre()
    {
        return nombre;
    }
    public String getPais()
    {
        return nombre;
    }

    public List<String> getAlumnos()
    {
        return alumnos;
    }

    public List<String> getCiudades()
    {
        return ciudades;
    }

    public void setAlumnos(String email) {
        alumnos.add(email);

    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", alumnos=" + alumnos +
                ", ciudades=" + ciudades +
                '}';
    }
}
