package Memoria;

import Entities.Alumno;
import Entities.Candidato;
import Enums.Modalidad;
import Enums.Traslado;

import java.util.*;

import static java.util.stream.Collectors.toMap;


public class Candidatos {

    private List<Candidato> candidatos;
    Alumnos alumnos;
    int numTraslados = 0;
    int numRemotos = 0;
    int numPresencialNoTraslado = 0;

    private Map<String, Integer> mapCiudad = new HashMap<String, Integer>();
    private Map<String, Integer> mapPais = new HashMap<String, Integer>();


    public Candidatos(Alumnos alumnos) {

        candidatos = new ArrayList();
        this.alumnos = alumnos;


    }

    @Override
    public String toString() {
        return "Candidatos{" +
                "candidatos=" + candidatos +
                '}';
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }


    public void añadir(Candidato candidato) {
        candidatos.add(candidato);

    }

    public Boolean borrar(Candidato candidato) {
        for (Candidato candidatoActual : candidatos) {
            if (candidatoActual.getEmail().equals(candidato.getEmail())) {
                return candidatos.remove(candidatoActual);

            }


        }
        return false;

    }

    public void filtrarCiudad(String ciudad) {

        for (Alumno alumno : alumnos.getAlumnos()) {
            if (alumno.getCiudad().getNombre().equals(ciudad)) {
                Candidato candidato = new Candidato(alumno.getEmail(), alumno.getTelefono());
                candidatos.add(candidato);

                actualizaCiudadPais(alumno);

               actualizaRemotosTraslados(alumno);
            }
        }


    }

    public void filtrarModalidad(Modalidad modalidad) {
        mapCiudad.clear();

        for (Alumno alumno : alumnos.getAlumnos()) {
            if (alumno.getModalidad().equals(modalidad)) {
                Candidato candidato = new Candidato(alumno.getEmail(), alumno.getTelefono());
                candidatos.add(candidato);

                actualizaCiudadPais(alumno);

                actualizaRemotosTraslados(alumno);
            }
        }





    }

    public void filtrarTraslado(Traslado traslado) {

        for (Alumno alumno : alumnos.getAlumnos()) {
            if (alumno.getTraslado().equals(traslado)) {
                Candidato candidato = new Candidato(alumno.getEmail(), alumno.getTelefono());
                candidatos.add(candidato);

                actualizaCiudadPais(alumno);

                actualizaRemotosTraslados(alumno);

            }
        }


    }

    public void filtrar(String ciudad, Modalidad modalidad, Traslado traslado) {
        for (Alumno alumno : alumnos.getAlumnos()) {
            if ((alumno.getCiudad().getNombre().equals(ciudad)) && (alumno.getModalidad().equals(modalidad))
                    && (alumno.getTraslado().equals(traslado))) {
                Candidato candidato = new Candidato(alumno.getEmail(), alumno.getTelefono());
                candidatos.add(candidato);

                actualizaCiudadPais(alumno);

                actualizaRemotosTraslados(alumno);

            }
        }

    }


    public Candidato buscarEmail(String email) {

        for (Candidato candidato : candidatos) {
            if (candidato.getEmail().equals(email)) {
                return candidato;

            }

        }
        return null;
    }

    public Candidato buscarTelefono(String telefono) {
        for (Candidato candidato : candidatos) {
            if (candidato.getTelefono().equals(telefono)) {
                return candidato;

            }

        }
        return null;
    }


    private void actualizaCiudadPais(Alumno alumno) {
        String ciudadAlumno = alumno.getCiudad().getNombre();
        String paisAlumno = alumno.getPais().getNombre();

        if (mapCiudad.containsKey(ciudadAlumno)) mapCiudad.replace(ciudadAlumno, mapCiudad.get(ciudadAlumno) + 1);
        else mapCiudad.put(ciudadAlumno, 1);

        if (mapPais.containsKey(paisAlumno)) mapPais.replace(paisAlumno, mapPais.get(paisAlumno) + 1);
        else mapPais.put(paisAlumno, 1);


    }

    public void imprimeCiudadesTop() {



        Map<String, Integer> sorted = mapCiudad
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        for (String clave:sorted.keySet()) {
            int valor = sorted.get(clave);
            System.out.println(  clave + " : " + valor);
        }




    }

    public void imprimePaisesTop() {



        Map<String, Integer> sorted = mapPais
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        for (String clave:sorted.keySet()) {
            int valor = sorted.get(clave);
            System.out.println(  clave + " : " + valor);
        }




    }


    public void actualizaRemotosTraslados(Alumno alumno)
    {
        if (alumno.getModalidad().equals(Modalidad.REMOTO)) numRemotos++;
        if (alumno.getTraslado().equals(Traslado.SI)) numTraslados++;
        if ((alumno.getTraslado().equals(Traslado.NO)) && (alumno.getModalidad().equals(Modalidad.PRESENCIAL)) ) numPresencialNoTraslado++;
    }
    public int totalRemotos(){

        return numRemotos;
    }

    public int totalPosibilidadTraslado()
    {
        return numTraslados;
    }

    public int totalPresencialSinTraslado(){

       return numPresencialNoTraslado;
    }
}
