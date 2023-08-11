package com.example.entity;

import jakarta.validation.constraints.NotNull;

public class Specification {

    @NotNull
    private Color color;
    @NotNull
    private EngineType engineType;

    public Specification(Color color, EngineType engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    public Color getColor() {
        return color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Specification setColor(Color color) {
        this.color = color;
        return this;
    }

    public Specification setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }
}
