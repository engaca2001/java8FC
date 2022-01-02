package Memoria;

import Entities.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class Ciudades {

    List<Ciudad> ciudades = new ArrayList<>();

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void añadirCiudad(Ciudad ciudad)
    {
        ciudades.add(ciudad);

    }
}
