package com.sisgebi.response;

public class TipoBienResponseRest extends ResponseRest {
    private TipoBienResponse tipoBienResponse = new TipoBienResponse();

    public TipoBienResponse getTipoBienResponse() {
        return tipoBienResponse;
    }

    public void setTipoBienResponse(TipoBienResponse tipoBienResponse) {
        this.tipoBienResponse = tipoBienResponse;
    }
}
