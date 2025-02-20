package com.sisgebi.response;

import com.sisgebi.entity.TipoBien;

import java.util.List;

public class TipoBienResponse {
    private List<TipoBien> tipoBienes;

    public List<TipoBien> getTipoBienes() {
        return tipoBienes;
    }

    public void setTipoBienes(List<TipoBien> tipoBienes) {
        this.tipoBienes = tipoBienes;
    }
}
