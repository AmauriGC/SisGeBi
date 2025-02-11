package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "area_comun")
public class AreaComun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;

    @NotBlank(message = "El nombre del área es obligatorio")
    @Column(name = "nombre_area", nullable = false)
    private String nombreArea;

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

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public @NotBlank(message = "El nombre del área es obligatorio") String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(@NotBlank(message = "El nombre del área es obligatorio") String nombreArea) {
        this.nombreArea = nombreArea;
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
