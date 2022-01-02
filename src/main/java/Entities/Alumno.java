package Entities;

import Enums.Modalidad;
import Enums.Traslado;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private  String email;
    private  String password;
    private  String nombreCompleto;
    private  String telefono;
    private Modalidad modalidad;
    private Traslado traslado;
    private  String foto;
    private  String cv;
    private  Pais pais;
    private  Ciudad ciudad;


    private List<String> lenguajes = new ArrayList();


    public Alumno(String email, String password, String nombreCompleto, String telefono, Modalidad modalidad, Traslado traslado, String foto, String cv, Pais pais, Ciudad ciudad) {
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.modalidad = modalidad;
        this.traslado = traslado;
        this.foto = foto;
        this.cv = cv;
        this.pais = pais;
        this.ciudad = ciudad;
        this.lenguajes = lenguajes;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public String getFoto() {
        return foto;
    }

    public String getCv() {
        return cv;
    }

    public Pais getPais() {
        return pais;
    }

    public Ciudad getCiudad()
    {
        return ciudad;
    }



    public List<String> getLenguajes()
    {
        return lenguajes;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", traslado='" + traslado + '\'' +
                ", foto='" + foto + '\'' +
                ", cv='" + cv + '\'' +
                ", pais='" + pais.getNombre() + '\'' +
                ", ciudad='" + ciudad.getNombre() + '\'' +
                ", lenguajes=" + lenguajes +
                '}';
    }

    public static class AlumnoBuilder
    {
        private  String email;
        private  String password;
        private  String nombreCompleto;
        private  String telefono;
        private  Modalidad modalidad;
        private  Traslado  traslado;
        private  String foto;
        private  String cv;
        private  Pais pais;
        private  Ciudad ciudad;

        public AlumnoBuilder(String email,String password)
        {
            this.email = email;
            this.password = password;

        }
        public Alumno build(){
            return new Alumno(this.email,this.password,this.nombreCompleto,this.telefono,this.modalidad,this.traslado,this.foto,this.cv,this.pais,this.ciudad);
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public String getTelefono() {
            return telefono;
        }

        public Modalidad getModalidad() {
            return modalidad;
        }

        public Traslado getTraslado() {
            return traslado;
        }

        public String getFoto() {
            return foto;
        }

        public String getCv() {
            return cv;
        }

        public Pais getPais() {
            return pais;
        }

        public Ciudad getCiudad() {
            return ciudad;
        }

        public AlumnoBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public AlumnoBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AlumnoBuilder setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
            return this;
        }

        public AlumnoBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public AlumnoBuilder setModalidad(Modalidad modalidad) {
            this.modalidad = modalidad;
            return this;
        }

        public AlumnoBuilder  setTraslado(Traslado traslado) {
            this.traslado = traslado;
            return this;
        }

        public AlumnoBuilder setFoto(String foto) {
            this.foto = foto;
            return this;
        }

        public AlumnoBuilder setCv(String cv) {
            this.cv = cv;
            return this;
        }

        public AlumnoBuilder setPais(Pais pais) {
            this.pais = pais;
            pais.setAlumnos(email);
            return this;
        }

        public AlumnoBuilder setCiudad(Ciudad ciudad) {
            this.ciudad = ciudad;
            return this;
        }
    }

}
