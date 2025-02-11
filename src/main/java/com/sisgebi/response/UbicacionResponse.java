package com.sisgebi.response;

import com.sisgebi.entity.Ubicacion;

import java.util.List;

public class UbicacionResponse {
    private List<Ubicacion> ubicaciones;

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
