package com.sisgebi.response;

import com.sisgebi.entity.AreaComun;
import java.util.List;

public class AreaComunResponseRest {

    private AreaComunResponse areaComunResponse;
    private String metadata;

    public AreaComunResponseRest() {
        this.areaComunResponse = new AreaComunResponse();
    }

    public AreaComunResponse getAreaComunResponse() {
        return areaComunResponse;
    }

    public void setAreaComunResponse(AreaComunResponse areaComunResponse) {
        this.areaComunResponse = areaComunResponse;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String message, String code, String description) {
        this.metadata = String.format("{\"message\":\"%s\", \"code\":\"%s\", \"description\":\"%s\"}", message, code, description);
    }
}
