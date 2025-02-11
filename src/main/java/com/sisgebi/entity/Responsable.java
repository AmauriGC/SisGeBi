package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "responsable")
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsable;

    @NotBlank(message = "El nombre completo es obligatorio")
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @NotBlank(message = "El usuario es obligatorio")
    @Column(unique = true, nullable = false)
    private String usuario;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    @NotBlank(message = "El lugar es obligatorio")
    private String lugar;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public @NotBlank(message = "El nombre completo es obligatorio") String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(@NotBlank(message = "El nombre completo es obligatorio") String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public @NotBlank(message = "El usuario es obligatorio") String getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotBlank(message = "El usuario es obligatorio") String usuario) {
        this.usuario = usuario;
    }

    public @NotBlank(message = "La contraseña es obligatoria") String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@NotBlank(message = "La contraseña es obligatoria") String contrasena) {
        this.contrasena = contrasena;
    }

    public @NotBlank(message = "El lugar es obligatorio") String getLugar() {
        return lugar;
    }

    public void setLugar(@NotBlank(message = "El lugar es obligatorio") String lugar) {
        this.lugar = lugar;
    }

    public @NotNull(message = "El estado es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado es obligatorio") Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
