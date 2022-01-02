package Memoria;



import Entities.Alumno;
import Seguridad.Cifrado;

import java.util.ArrayList;
import java.util.List;

public  class Alumnos {

    private  List<Alumno> alumnos = new ArrayList();

    public Alumnos() {

    }

    public   List<Alumno> getAlumnos() {

        return alumnos;
    }

    public void borrar(Alumno alumno)
    {
        alumnos.remove(alumno);

    }

    public void añadirAlumno(Alumno alumno)
    {
        alumnos.add(alumno);
    }


    public  boolean register(String email, String password)
    {
        Alumno alumno= new Alumno.AlumnoBuilder(email,password).build();
        Cifrado seguridad = new Cifrado();

       for (Alumno alumLista: alumnos)
       {

           if (alumLista.getEmail().equals(alumno.getEmail())) return false;
       }


        alumno.setPassword(seguridad.usarArgon2(password));

        alumnos.add(alumno);

        return true;
    }

   public  int login(String email, String password)
    {
        Alumno alumno= new Alumno.AlumnoBuilder(email,password).setPassword(password).build();
        Cifrado seguridad = new Cifrado();

        for (Alumno alumLista: alumnos)
        {
            if (alumLista.getEmail().equals(email)) {

                String hash = alumLista.getPassword();
                if (seguridad.verificar(hash,password)) return 1;

                else return -2;
            }

        }
        return -1;
    }




}
