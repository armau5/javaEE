package com.example.controll;

import com.example.entity.Color;
import jakarta.enterprise.inject.Produces;

public class DefaultColorExposer {

    @Produces
    @Diesel
    public Color exposeDefaultColor(){
        return Color.RED;


    }
}
