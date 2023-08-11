package com.example.controll;

import com.example.entity.CarCreated;
import jakarta.enterprise.event.Observes;

public class CarCreationEvent {

    private void onCarCreation(@Observes CarCreated carCreated){
        System.out.println("new car create with id : " + carCreated.getIdentified());
    }
}
