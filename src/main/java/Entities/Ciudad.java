package Entities;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    String nombre;
    String pais;

    List<String> alumnos = new ArrayList();

    public Ciudad(String nombre, Pais pais)
    {
        this.nombre = nombre;
        this.pais = pais.getPais();
        pais.getCiudades().add(nombre);

    }

    public String getNombre()
    {
        return nombre;
    }

    public List<String> getUsuarios()
    {
        return alumnos;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", usuarios=" + alumnos +
                '}';
    }
}
