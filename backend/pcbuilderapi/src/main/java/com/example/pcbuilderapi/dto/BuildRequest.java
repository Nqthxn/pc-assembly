package com.example.pcbuilderapi.dto;

import java.util.List;

public class BuildRequest {
    private String buildName;
    private List<Long> componentIds;

    public void setBuildName(String buildName){ this.buildName = buildName; }
    public void setComponentIds(List<Long> componentIds){ this.componentIds = componentIds; }

    public String getBuildName(){ return buildName; }
    public List<Long> getComponentIds(){ return componentIds; }
}
