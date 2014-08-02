package com.boothj5.dropwizardplay.resources;

import com.boothj5.dropwizardplay.core.Person;
import com.boothj5.dropwizardplay.store.PersonStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Path("/people")
public class PersonResource {

    private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

    private final PersonStore store;

    public PersonResource(PersonStore store) {
        this.store = store;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Long, Person> getUsers() {
        return store.getPeople();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getUser(@PathParam("id") Long id) {
        return store.getPerson(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Person user) throws URISyntaxException {
        long id = store.addUser(user);
        return Response.created(new URI("/" + id)).build();
    }
}
