package com.curso.resource;

import com.curso.dto.HelloResponseDto;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<HelloResponseDto> hello(@QueryParam("name") @DefaultValue("World") String name) {
    var response = HelloResponseDto.builder()
        .name(String.format("Hello %s", name))
        .build();
    return Uni.createFrom().item(response);
  }

}