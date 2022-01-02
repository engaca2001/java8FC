package Entities;

import Memoria.Alumnos;

public class Usuario {


    private Alumnos alumnos;

    public Usuario(Alumnos alumnos) {
         this.alumnos = alumnos;

    }

    public boolean register(String email, String password){


        return  alumnos.register(email,password);


    }

    public int login(String email, String password)
    {

        return alumnos.login(email,password);
    }

    public Alumnos getAlumnos()
    {
        return alumnos;
    }



    public void matricula(Alumno alumno, Lenguaje lenguaje)
    {
        alumno.getLenguajes().add(lenguaje.getNombre());
        lenguaje.getUsuarios().add(alumno.getEmail());

    }

    public Boolean desmatricular(Alumno alumno,Lenguaje lenguaje)
    {

        return alumno.getLenguajes().remove(lenguaje);
    }

    public int buscar(String email)
    {
        for (int i=0; i<alumnos.getAlumnos().size(); i++)
        {
            if (alumnos.getAlumnos().get(i).getEmail().equals(email)) return i;
        }

        return -1;
    }




}
