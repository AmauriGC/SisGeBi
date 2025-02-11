package com.sisgebi.response;

import com.sisgebi.entity.HistoricoBien;

import java.util.List;

public class HistoricoBienResponse {
    private List<HistoricoBien> historicos;

    public List<HistoricoBien> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoBien> historicos) {
        this.historicos = historicos;
    }
}
