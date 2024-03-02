package org.example.entity;

public class ProjectWorker {
    private Integer projectId;
    private Integer workerId;

    public ProjectWorker() {
    }

    public ProjectWorker(Integer projectId, Integer workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }
    public Integer getProjectId() {
        return projectId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

}
