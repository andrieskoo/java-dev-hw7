package org.example.entity;

import java.time.LocalDate;

public class Project {
    private String name;
    private Integer clientId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project(Integer clientId, String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClientId() {
        return clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

}
