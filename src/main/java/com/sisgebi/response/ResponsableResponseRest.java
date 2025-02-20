package com.sisgebi.response;

public class ResponsableResponseRest extends ResponseRest {
    private ResponsableResponse responsableResponse = new ResponsableResponse();

    public ResponsableResponse getResponsableResponse() {
        return responsableResponse;
    }

    public void setResponsableResponse(ResponsableResponse responsableResponse) {
        this.responsableResponse = responsableResponse;
    }
}
