package com.boothj5.dropwizardplay;

import com.boothj5.dropwizardplay.core.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GlobalExceptionMapper implements ExceptionMapper<RuntimeException> {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException e) {
        LOG.error("Error", e);
        return Response.serverError().entity(new ErrorResponse(e)).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
