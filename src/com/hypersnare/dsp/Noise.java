package com.hypersnare.dsp;

/**
 * Noise is a noise source
 */

public class Noise implements Source {
    private int bitcrush;
    private int count;
    private double sample;

    /**
     * Constructs a new Noise object
     * with default values
     */
    public Noise() {
        bitcrush = 1;
        count = 0;
        sample = 0;
    }

    /**
     * Ticks the noise, getting a new value
     * @return a double of the new noise value
     */
    public double tick() {
        count++;
        if (count % bitcrush == 0) {
            sample = Math.random() * 2.0 - 1.0;
            count = 0;
        }
        return sample;
    }

    /**
     * Randomizes the noise
     */
    public void randomize() {
        bitcrush = (int) (Math.random() * 10);
    }
}
