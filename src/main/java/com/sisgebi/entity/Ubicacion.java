package com.sisgebi.entity;

import com.sisgebi.enums.TipoUbicacion;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    @Enumerated(EnumType.STRING)
    private TipoUbicacion tipoUbicacion; // Enum: AreaComun, Becario

    @ManyToOne
    @JoinColumn(name = "id_area")
    private AreaComun area;

    @ManyToOne
    @JoinColumn(name = "id_becario")
    private Becario becario;

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

    public Long getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Long idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public TipoUbicacion getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(TipoUbicacion tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public AreaComun getArea() {
        return area;
    }

    public void setArea(AreaComun area) {
        this.area = area;
    }

    public Becario getBecario() {
        return becario;
    }

    public void setBecario(Becario becario) {
        this.becario = becario;
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
