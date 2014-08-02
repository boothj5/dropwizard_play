package com.boothj5.dropwizardplay.core;

public class ErrorResponse {
    private String error;

    public ErrorResponse(RuntimeException e) {
        if (e.getMessage() != null) {
            this.error = e.getMessage();
        } else {
            this.error = "Unknown";
        }
    }

    public String getError() {
        return error;
    }
}