package com.sisgebi.response;

import com.sisgebi.entity.Becario;

import java.util.List;

public class BecarioResponse {
    private List<Becario> becarios;

    public List<Becario> getBecarios() {
        return becarios;
    }

    public void setBecarios(List<Becario> becarios) {
        this.becarios = becarios;
    }
}
