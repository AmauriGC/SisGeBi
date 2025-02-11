package com.sisgebi.response;

public class BienResponseRest extends ResponseRest {
    private BienResponse bienResponse = new BienResponse();

    public BienResponse getBienResponse() {
        return bienResponse;
    }

    public void setBienResponse(BienResponse bienResponse) {
        this.bienResponse = bienResponse;
    }
}
