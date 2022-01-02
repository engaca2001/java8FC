package Memoria;

import Entities.Pais;

import java.util.ArrayList;
import java.util.List;

public class Paises {

    List<Pais> paises = new ArrayList<>();

    public List<Pais> getPaises() {
        return paises;
    }

    public void añadirPais(Pais pais)
    {
        paises.add(pais);
    }
}
