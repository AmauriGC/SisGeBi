package com.sisgebi.entity;

import com.sisgebi.enums.EstadoBien;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "bienes")
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBien;

    @NotNull(message = "El tipo de bien es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_tipo_bien", nullable = false)
    private TipoBien tipoBien;

    @NotNull(message = "La marca es obligatoria")
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @NotNull(message = "El modelo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @NotBlank(message = "El número de serie es obligatorio")
    @Column(unique = true, nullable = false)
    private String numeroSerie;

    @NotBlank(message = "El código es obligatorio")
    @Column(unique = true, nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion_actual")
    private Ubicacion ubicacionActual;

    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    private EstadoBien estado;

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

    public Long getIdBien() {
        return idBien;
    }

    public void setIdBien(Long idBien) {
        this.idBien = idBien;
    }

    public @NotNull(message = "El tipo de bien es obligatorio") TipoBien getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(@NotNull(message = "El tipo de bien es obligatorio") TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }

    public @NotNull(message = "La marca es obligatoria") Marca getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "La marca es obligatoria") Marca marca) {
        this.marca = marca;
    }

    public @NotNull(message = "El modelo es obligatorio") Modelo getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull(message = "El modelo es obligatorio") Modelo modelo) {
        this.modelo = modelo;
    }

    public @NotBlank(message = "El número de serie es obligatorio") String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(@NotBlank(message = "El número de serie es obligatorio") String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public @NotBlank(message = "El código es obligatorio") String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NotBlank(message = "El código es obligatorio") String codigo) {
        this.codigo = codigo;
    }

    public Ubicacion getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(Ubicacion ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public @NotNull(message = "El estado es obligatorio") EstadoBien getEstado() {
        return estado;
    }

    public void setEstado(@NotNull(message = "El estado es obligatorio") EstadoBien estado) {
        this.estado = estado;
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
