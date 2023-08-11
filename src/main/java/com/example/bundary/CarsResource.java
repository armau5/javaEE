package com.example.bundary;

import com.example.entity.Car;
import com.example.entity.EngineType;
import com.example.entity.Specification;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.stream.JsonCollectors;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;


import java.net.URI;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarsResource {

    @Inject
    CarManufacturer carManufacturer;

    @Context
    UriInfo uriInfo;
    @GET
    public JsonArray retrieveCars(@NotNull @QueryParam("filter") EngineType engineType) {
        return carManufacturer.retrieveCars(engineType)
                .stream()
                .map(c -> Json.createObjectBuilder()
                        .add("identifier", c.getIdentifier())
                        .add("color", c.getColor().name())
                        .add("engine", c.getEngineType().name())
                        .build())
                .collect(JsonCollectors.toJsonArray());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(@Valid @NotNull Specification specification) {
        Car car = carManufacturer.manufactureCar(specification);

        URI uri = uriInfo.getBaseUriBuilder()
                .path(CarsResource.class)
                .path(CarsResource.class, "retrieveCar")
                .build(car.getIdentifier());

        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Car retrieveCar(@PathParam("id") String identified){
        return carManufacturer.retrieveCar(identified);
    }
}
