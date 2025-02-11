package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_bien")
public class TipoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoBien;

    @NotBlank(message = "El nombre del tipo de bien es obligatorio")
    @Column(name = "nombre_tipo_bien", nullable = false)
    private String nombreTipoBien;

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

    public Long getIdTipoBien() {
        return idTipoBien;
    }

    public void setIdTipoBien(Long idTipoBien) {
        this.idTipoBien = idTipoBien;
    }

    public @NotBlank(message = "El nombre del tipo de bien es obligatorio") String getNombreTipoBien() {
        return nombreTipoBien;
    }

    public void setNombreTipoBien(@NotBlank(message = "El nombre del tipo de bien es obligatorio") String nombreTipoBien) {
        this.nombreTipoBien = nombreTipoBien;
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
