package Entities;

public class Candidato {

    private String email;
    private String telefono;

    public Candidato(String email, String telefono) {
        this.email = email;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }



    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
