package agenda_contacto.dominio;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "contactos", schema = "agenda_contacto")
@NamedQueries({
        @NamedQuery(name="contacto.findAll",query = "SELECT c FROM Contacto c"),
        @NamedQuery(name="contacto.findByTelefono",query = "SELECT c FROM Contacto c WHERE c.telefono=: telefono")
})

public class Contacto implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "telefono")
    private String telefono;

    @Column(name = "nombres", length = 45)
    private String nombres;

    @Column(name = "apellidos", length = 45)
    private String apellidos;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "cargo", length = 45)
    private String cargo;

    public Contacto() {}

    public Contacto(Integer id) {
        this.id = id;
    }

    public Contacto(String telefono) {
        this.telefono = telefono;
    }

    public Contacto(String telefono, String nombres, String apellidos, String correo, String direccion, String cargo) {
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "\nid=" + id+'\n' +
                "telefono=" + telefono + '\n' +
                "nombres=" + nombres + '\n' +
                "apellidos=" + apellidos + '\n' +
                "correo=" + correo + '\n' +
                "direccion=" + direccion + '\n' +
                "cargo=" + cargo + '\n';
    }
}