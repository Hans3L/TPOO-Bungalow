package main.java.clases;

public class Usuario {

    private int userId;
    private String name;
    private String lastName;
    private String dni;
    private String telefono;

    public Usuario(int userId, String name, String lastName, String dni, String telefono) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Codigo =" + userId +
                ", Nombre ='" + name + '\'' +
                ", Apellidos ='" + lastName + '\'' +
                ", DNI ='" + dni + '\'' +
                ", Telefono='" + telefono + '\'' +
                '}';
    }
}
