package com.hypersnare.dsp;

/**
 * Noise is a noise source
 */

public class Noise implements Source {
    private Processor bitcrush;

    /**
     * Constructs a new Noise object
     * with default values
     */
    public Noise() {
        bitcrush = new BitCrusher();
    }

    /**
     * Ticks the noise, getting a new value
     * @return a double of the new noise value
     */
    public double tick() {
        bitcrush.process(Math.random() * 2.0 - 1.0);
        return bitcrush.tick();
    }

    /**
     * Randomizes the noise
     */
    public void randomize() {
        bitcrush.randomize();
    }
}
