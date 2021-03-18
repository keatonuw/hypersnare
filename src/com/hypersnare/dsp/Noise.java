package com.hypersnare.dsp;

public class Noise implements Source {
    public double tick() {
        return Math.random() * 2.0 - 1.0;
    }
}
