package com.boothj5.dropwizardplay.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    private String error;

    public ErrorResponse() {}

    public ErrorResponse(RuntimeException e) {
        if (e.getMessage() != null) {
            this.error = e.getMessage();
        } else {
            this.error = "Unknown";
        }
    }

    @JsonProperty
    public String getError() {
        return error;
    }
}