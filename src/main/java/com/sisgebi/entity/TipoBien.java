package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document(collection = "tipobien")
public class TipoBien {

    @Id
    private String idTipoBien;  // MongoDB usa ObjectId, que es String.

    @NotBlank(message = "El nombre del tipo de bien es obligatorio")
    private String nombreTipoBien;

    @NotNull(message = "El estado del tipo de bien es obligatorio")
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters y Setters

    public String getIdTipoBien() {
        return idTipoBien;
    }

    public void setIdTipoBien(String idTipoBien) {
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
