package com.sisgebi.response;

import com.sisgebi.entity.TipoBien;

import java.util.List;

public class TipoBienResponse {
    private List<TipoBien> tiposBienes;

    public List<TipoBien> getTiposBienes() {
        return tiposBienes;
    }

    public void setTiposBienes(List<TipoBien> tiposBienes) {
        this.tiposBienes = tiposBienes;
    }
}
