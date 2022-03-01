package com.bbva.pzic.proposals.v0.processtasks.business.dto;

import com.bbva.pzic.proposals.v0.processtasks.util.ValidationGroup;

import javax.validation.constraints.NotNull;

public class InputListProcessTasksProposals {


    private String bussinessProccessId;
    private String taskId;

    public String getBussinessProccessId() {
        return bussinessProccessId;
    }

    public void setBussinessProccessId(String bussinessProccessId) {
        this.bussinessProccessId = bussinessProccessId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
