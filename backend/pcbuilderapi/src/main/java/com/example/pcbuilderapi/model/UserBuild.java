package com.example.pcbuilderapi.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_builds")
public class UserBuild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String buildName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "build_component_ids", joinColumns = @JoinColumn(name = "build_id"))
    @Column(name = "component_id")
    private List<Long> componentIds;

    public UserBuild(){}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBuildName() { return buildName; }
    public void setBuildName(String buildName) { this.buildName = buildName; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<Long> getComponentIds() { return componentIds; }
    public void setComponentIds(List<Long> componentIds) { this.componentIds = componentIds; }
}
