package com.example.bundary;

import com.example.controll.CarFactory;
import com.example.controll.CarRepository;
import com.example.entity.Car;
import com.example.entity.CarCreated;
import com.example.entity.EngineType;
import com.example.entity.Specification;
import jakarta.ejb.Stateless;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import javax.enterprise.event.Event;
@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;
    @Inject
    CarRepository carRepository;
    @Inject
    Event<CarCreated> createdCar;

    public Car manufactureCar(Specification specification) {
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        createdCar.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    public List<Car> retrieveCars(@NotNull EngineType engineType){
       return carRepository.loadCars();
    }

    public Car retrieveCar(String identifier) {
        Car car = new Car();
        car.setIdentifier(identifier);
        return car;
    }
}
