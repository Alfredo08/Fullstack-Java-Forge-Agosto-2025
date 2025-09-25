package com.alfredosalazar.autoresylibros.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, message = "Por favor proporciona tu nombre.")
    private String nombre;

    @Email(message="Por favor proporciona un correo válido.")
    private String correo;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",
             message = "La contraseña necesita incluir al menos una mayúscula, una minúscula y un número.")
    private String contrasenia;

    @Transient
    private String confirmarContrasenia;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_creacion")
    private Date fechaCreacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_actualizacion")
    private Date fechaActualizacion;

    public Autor(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getConfirmarContrasenia() {
        return confirmarContrasenia;
    }

    public void setConfirmarContrasenia(String confirmarContrasenia) {
        this.confirmarContrasenia = confirmarContrasenia;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @PrePersist
    protected void onCreate(){
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.fechaActualizacion = new Date();
    }
}
