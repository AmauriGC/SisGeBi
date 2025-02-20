package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document(collection = "ubicacion")
public class Ubicacion {

    @Id
    private String idUbicacion;

    @NotBlank(message = "El tipo de ubicación es obligatorio")
    private String tipoUbicacion;  // 'AreaComun' o 'Becario'

    @DBRef
    private AreaComun areaComun;  // Relación con AreaComun

    @DBRef
    private Becario becario;      // Relación con Becario

    @NotNull(message = "El estado de la ubicación es obligatorio")
    private Status status;  // Estado de la ubicación (ACTIVO / INACTIVO)

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters y Setters

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(String tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public AreaComun getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(AreaComun areaComun) {
        this.areaComun = areaComun;
    }

    public Becario getBecario() {
        return becario;
    }

    public void setBecario(Becario becario) {
        this.becario = becario;
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
