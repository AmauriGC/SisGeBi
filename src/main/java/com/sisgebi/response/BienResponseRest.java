package com.sisgebi.response;

import com.sisgebi.entity.Bien;
import java.util.List;

public class BienResponseRest {

    private BienResponse bienResponse = new BienResponse();
    private String metadata;

    public BienResponse getBienResponse() {
        return bienResponse;
    }

    public void setBienResponse(BienResponse bienResponse) {
        this.bienResponse = bienResponse;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String message, String code, String description) {
        this.metadata = String.format("{\"message\":\"%s\", \"code\":\"%s\", \"description\":\"%s\"}", message, code, description);
    }
}
