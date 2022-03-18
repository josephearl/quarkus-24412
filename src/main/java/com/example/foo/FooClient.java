package com.example.foo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/v1/")
@RegisterRestClient(configKey = "foo")
public interface FooClient {
  @GET
  @Path("foos")
  @Produces(MediaType.APPLICATION_JSON)
  FoosResponse getFoos(int page, int limit);
}
