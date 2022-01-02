import Entities.*;
import Enums.Modalidad;
import Enums.Traslado;
import Memoria.Alumnos;
import Memoria.Candidatos;
import Output.Impresion;

public class Main {

    public static void main(String[] args) {

        Alumnos alumnos = new Alumnos();

        Pais pais1 = new Pais("España");
        Pais pais2 = new Pais("Francia");

        Ciudad madrid = new Ciudad("Madrid",pais1);
        Ciudad barcelona = new Ciudad("Barcelona",pais1);


        Lenguaje lenguaje1= new Lenguaje("java");
        Lenguaje lenguaje2= new Lenguaje("python");


        //// Usuario 1 ////
        Usuario usuario1 = new Usuario(alumnos);


        usuario1.register("engaca2001@hotmail.com","palomino");


        usuario1.login("engaca2001@hotmail.com","palomino");

        int posicionAlumno = usuario1.buscar("engaca2001@hotmail.com");

        String passAlumno = alumnos.getAlumnos().get(posicionAlumno).getPassword();

        Alumno.AlumnoBuilder builder = new Alumno.AlumnoBuilder("engaca2001@hotmail.com",passAlumno);


        Alumno alumno1 = builder.setNombreCompleto("Enrique Gallego Cabrales")
                .setTelefono("660046935")
                .setCv("Cv")
                .setFoto("foto")
                .setModalidad(Modalidad.PRESENCIAL)
                .setTraslado(Traslado.NO)
                .setCiudad(madrid)
                .setPais(pais1)
                .build();

        alumnos.getAlumnos().remove(usuario1.buscar(alumno1.getEmail()));

        alumnos.añadirAlumno(alumno1);

        usuario1.matricula(alumno1,lenguaje1);
        usuario1.matricula(alumno1,lenguaje2);


       /////////////////// añadir otro alumnos otro ususario /////////////////////////////

        Usuario usuario2 = new Usuario(alumnos);


        usuario2.register("ngaca2001@hotmail.com","palomino");


        usuario2.login("ngaca2001@hotmail.com","palomino");

        int posicionAlumno2 = usuario2.buscar("ngaca2001@hotmail.com");

        String passAlumno2 = alumnos.getAlumnos().get(posicionAlumno2).getPassword();

        Alumno.AlumnoBuilder builder2 = new Alumno.AlumnoBuilder("ngaca2001@hotmail.com",passAlumno2);

        Alumno alumno2 = builder2.setNombreCompleto("Enrique Gallego Cabrales")
                .setTelefono("660046935")
                .setCv("Cv")
                .setFoto("foto")
                .setModalidad(Modalidad.REMOTO)
                .setTraslado(Traslado.SI)
                .setCiudad(barcelona)
                .setPais(pais1)
                .build();

        alumnos.getAlumnos().remove(usuario2.buscar(alumno2.getEmail()));

        alumnos.añadirAlumno(alumno2);

        usuario2.matricula(alumno2,lenguaje1);
        usuario2.matricula(alumno2,lenguaje2);




        /////////////////// añadir otro alumnos otro ususario /////////////////////////////

        Usuario usuario3 = new Usuario(alumnos);


        usuario3.register("gaca2001@hotmail.com","palomino");


        usuario2.login("gaca2001@hotmail.com","palomino");

        int posicionAlumno3 = usuario3.buscar("gaca2001@hotmail.com");

        String passAlumno3 = alumnos.getAlumnos().get(posicionAlumno3).getPassword();

        Alumno.AlumnoBuilder builder3 = new Alumno.AlumnoBuilder("gaca2001@hotmail.com",passAlumno3);


        Alumno alumno3 = builder3.setNombreCompleto("Enrique Gallego Cabrales")
                .setTelefono("660046935")
                .setCv("Cv")
                .setFoto("foto")
                .setModalidad(Modalidad.REMOTO)
                .setTraslado(Traslado.NO)
                .setCiudad(madrid)
                .setPais(pais1)
                .build();

        alumnos.getAlumnos().remove(usuario3.buscar(alumno3.getEmail()));

        alumnos.añadirAlumno(alumno3);

        usuario3.matricula(alumno3,lenguaje1);
        usuario3.matricula(alumno3,lenguaje2);


        ///////////////////////////////////////////////////////////////////////////////////


        Candidatos candidatos = new Candidatos(alumnos);

        candidatos.filtrarCiudad("Madrid");

        System.out.println("Ciudades top:");
        candidatos.imprimeCiudadesTop();

        System.out.println("Paises top");
        candidatos.imprimePaisesTop();

        System.out.println("Total de candidatos que quieren trabajar en remoto: " + candidatos.totalRemotos());
        System.out.println("Total de candidatos que pueden trasladarse: " + candidatos.totalPosibilidadTraslado());
        System.out.println("Total de candidatos presencial y no traslado: " + candidatos.totalPresencialSinTraslado());



    }


}
