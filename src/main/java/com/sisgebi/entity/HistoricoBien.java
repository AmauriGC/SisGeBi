package com.sisgebi.entity;

import com.sisgebi.enums.TipoMovimiento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_bien")
public class HistoricoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;

    @NotNull(message = "El bien es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_bien", nullable = false)
    private Bien bien;

    @NotNull(message = "El tipo de movimiento es obligatorio")
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    @NotBlank(message = "El detalle es obligatorio")
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

    public @NotNull(message = "El bien es obligatorio") Bien getBien() {
        return bien;
    }

    public void setBien(@NotNull(message = "El bien es obligatorio") Bien bien) {
        this.bien = bien;
    }

    public @NotNull(message = "El tipo de movimiento es obligatorio") TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(@NotNull(message = "El tipo de movimiento es obligatorio") TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public @NotBlank(message = "El detalle es obligatorio") String getDetalle() {
        return detalle;
    }

    public void setDetalle(@NotBlank(message = "El detalle es obligatorio") String detalle) {
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
