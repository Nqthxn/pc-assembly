package com.example.pcbuilderapi.dto;

import java.util.List;

public class BuildResponse {
    private Long id;
    private String buildName;
    private List<Long> componentIds;
    
    public BuildResponse(Long id, String buildName, List<Long> componentIds){
        this.id = id;
        this.buildName = buildName;
        this.componentIds = componentIds;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBuildName() { return buildName; }
    public void setBuildName(String buildName) { this.buildName = buildName; }
    public List<Long> getComponentIds() { return componentIds; }
    public void setComponentIds(List<Long> componentIds) { this.componentIds = componentIds; }
}
