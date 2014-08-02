package com.boothj5.dropwizardplay.core;

public class ErrorResponse {
    private static final String DEFAULT_ERROR_MESAGE = "Unknown";
    private String error;

    public ErrorResponse(RuntimeException e) {
        if (e.getMessage() != null) {
            this.error = e.getMessage();
        } else {
            this.error = DEFAULT_ERROR_MESAGE;
        }
    }

    public ErrorResponse(String message) {
        this.error = message;
    }

    public static ErrorResponse notFound() {
        return new ErrorResponse("Not found.");
    }

    public String getError() {
        return error;
    }
}