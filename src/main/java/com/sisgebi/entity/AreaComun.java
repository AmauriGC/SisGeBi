package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document(collection = "areaComun")
public class AreaComun {

    @Id
    private String idAreaComun;

    @Indexed
    @NotBlank(message = "El nombre del área es obligatorio")
    private String nombreArea;

    @NotBlank(message = "La descripción del área es obligatoria")
    private String descripcion;

    @NotNull(message = "El estado del área es obligatorio")
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters y Setters
    public String getIdAreaComun() {
        return idAreaComun;
    }

    public void setIdAreaComun(String idAreaComun) {
        this.idAreaComun = idAreaComun;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
