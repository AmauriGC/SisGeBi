package com.sisgebi.response;

import com.sisgebi.entity.Marca;

import java.util.List;

public class MarcaResponse {
    private List<Marca> marcas;

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
}
