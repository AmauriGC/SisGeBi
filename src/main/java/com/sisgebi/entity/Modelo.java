package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModelo;

    @NotBlank(message = "El nombre del modelo es obligatorio")
    @Column(name = "nombre_modelo", nullable = false)
    private String nombreModelo;

    private String foto;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "La marca es obligatoria")
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

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

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public @NotBlank(message = "El nombre del modelo es obligatorio") String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(@NotBlank(message = "El nombre del modelo es obligatorio") String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public @NotNull(message = "El estado es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado es obligatorio") Status status) {
        this.status = status;
    }

    public @NotNull(message = "La marca es obligatoria") Marca getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "La marca es obligatoria") Marca marca) {
        this.marca = marca;
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
