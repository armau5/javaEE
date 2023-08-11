package com.example.entity;

public class Car {

    private String identifier;
    private Color color;
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
