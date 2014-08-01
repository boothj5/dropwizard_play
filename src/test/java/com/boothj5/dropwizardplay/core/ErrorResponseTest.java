package com.boothj5.dropwizardplay.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorResponseTest {

    @Test
    public void showsMessage() throws Exception {
        ErrorResponse response = new ErrorResponse(new RuntimeException("Oh no"));
        assertEquals("Oh no", response.getError());
    }

    @Test
    public void showsUnknownWhenNoMessage() throws Exception {
        ErrorResponse response = new ErrorResponse(new RuntimeException());
        assertEquals("Unknown", response.getError());
    }
}