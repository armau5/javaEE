package com.example.bundary;

import com.example.entity.Car;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResources {

    @Inject
    CarManufacturer carManufacturer;

    @GET
    public List<Car> retrieveCar() {
        return carManufacturer.retrieveCars();
    }
}
