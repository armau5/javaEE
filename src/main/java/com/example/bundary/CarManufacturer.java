package com.example.bundary;

import com.example.controll.CarFactory;
import com.example.controll.CarRepository;
import com.example.entity.Car;
import com.example.entity.CarCreated;
import com.example.entity.Specification;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;
    @Inject
    CarRepository carRepository;
    @Inject
    Event<CarCreated> createdCar;

    public Car manufacturer(Specification specification) {
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        createdCar.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    public List<Car> retrieveCars(){
       return carRepository.loadCars();
    }

}
