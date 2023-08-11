package com.example.controll;

import com.example.entity.Car;
import com.example.entity.Color;
import com.example.entity.Specification;
import jakarta.inject.Inject;

import java.util.UUID;

public class CarFactory {

    @Inject
    @Diesel
    Color defauleCarColor;

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(UUID.randomUUID().toString());
        car.setColor(specification.getColor() == null ? defauleCarColor : specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }
}