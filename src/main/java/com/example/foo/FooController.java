package com.example.foo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@ApplicationScoped
@Path("/api/v1/foos")
public class FooController {
  private final FooClient fooClient;

  public FooController(@Named("fake") FooClient fooClient) {
    this.fooClient = fooClient;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "Foos",
            content = @Content(schema = @Schema(implementation = FoosResponse.class))),
        @APIResponse(responseCode = "500", description = "Unexpected error"),
      })
  public FoosResponse getFoos(
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("limit") @DefaultValue("50") int limit) {
    return fooClient.getFoos(page, limit);
  }
}
