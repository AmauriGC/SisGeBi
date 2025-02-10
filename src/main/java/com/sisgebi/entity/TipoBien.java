package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_bien")
public class TipoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoBien;

    private String nombreTipoBien;

    @Enumerated(EnumType.STRING)
    private Status status; // Asume que tienes una enum Status {ACTIVO, INACTIVO}

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

    public String getNombreTipoBien() {
        return nombreTipoBien;
    }

    public void setNombreTipoBien(String nombreTipoBien) {
        this.nombreTipoBien = nombreTipoBien;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
