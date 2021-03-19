package com.hypersnare.dsp;

public class Saturator implements Processor {
    public static final double SATURATION = 0.333333;
    private double mix;

    public Saturator() {
        mix = 1;
    }
    /**
     * Processes the incoming signal, and
     * returns a new value
     *
     * @param in a double to process
     * @return a double of what has been processed
     */
    public double tick(double in) {
        double distorted = 0;
        if (in > 0) {
            distorted = Math.pow(in, SATURATION);
        } else {
            distorted = -Math.pow(-in, SATURATION);
        }
        return distorted * mix + (1.0 - mix) * in;
    }

    /**
     * Gets the current sample from the Source
     *
     * @return a double of the sample
     */
    public double tick() {
        return mix;
    }

    /**
     * Randomizes the values of the Source
     */
    public void randomize() {
        mix = Math.random();
    }
}
