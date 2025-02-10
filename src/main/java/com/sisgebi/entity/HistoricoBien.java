package com.sisgebi.entity;

import com.sisgebi.enums.TipoMovimiento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_bien")
public class HistoricoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;

    @ManyToOne
    @JoinColumn(name = "id_bien", nullable = false)
    private Bien bien;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento; // Enum: ASIGNACION, CAMBIO_UBICACION, CAMBIO_RESPONSABLE, CAMBIO_ESTADO

    private String detalle;

    @Column(updatable = false)
    private LocalDateTime fecha;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

    public Long getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
