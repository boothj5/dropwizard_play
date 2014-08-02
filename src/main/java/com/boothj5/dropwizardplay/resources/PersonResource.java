package com.boothj5.dropwizardplay.resources;

import com.boothj5.dropwizardplay.core.ErrorResponse;
import com.boothj5.dropwizardplay.core.Person;
import com.boothj5.dropwizardplay.store.PersonStore;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Path("/people")
public class PersonResource {

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
    public Response getUser(@PathParam("id") Long id) {
        Person person = store.getPerson(id);

        if (person != null) {
            return Response
                    .ok()
                    .entity(person)
                    .build();
        } else {
            return Response
                    .status(HttpStatus.NOT_FOUND_404)
                    .entity(new ErrorResponse("Not found"))
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Person user) throws URISyntaxException {
        long id = store.addUser(user);

        return Response
                .created(new URI("/" + id))
                .build();
    }
}
