package com.example.project.model;

public class ErrorResponse {
    // fail login
    private String status;
    private Error error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.example.project.model.Error getError() {
        return error;
    }

    public void setError(com.example.project.model.Error error) {
        this.error = error;
    }
}
