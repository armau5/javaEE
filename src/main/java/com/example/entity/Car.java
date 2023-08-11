package com.example.entity;

import jakarta.json.bind.annotation.JsonbProperty;

public class Car {

    @JsonbProperty
    private String identifier;
    private Color color;
    @JsonbProperty("engine")
    private EngineType engineType;



    public String getIdentifier() {
        return identifier;
    }

    public Car setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Car setColor(Color color) {
        this.color = color;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Car setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }
}
