package com.sisgebi.response;

import com.sisgebi.entity.Bien;

import java.util.List;

public class BienResponse {
    private List<Bien> bienes;

    public List<Bien> getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }
}
