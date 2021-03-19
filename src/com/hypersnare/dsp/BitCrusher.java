package com.hypersnare.dsp;

public class BitCrusher implements Processor {
    private double sample;
    private int sampleDivision;
    private int count;

    public BitCrusher() {
        sample = 0;
        sampleDivision = 1;
        count = 0;
    }
    /**
     * Processes the incoming signal, and
     * returns a new value
     *
     * @param in a double to process
     * @return a double of what has been processed
     */
    public double tick(double in) {
        count++;
        if (count >= sampleDivision) {
            count = 0;
            sample = in;
        }
        return sample;
    }

    /**
     * Gets the current sample from the Source
     *
     * @return a double of the sample
     */
    public double tick() {
        return sample;
    }

    /**
     * Randomizes the values of the Source
     */
    public void randomize() {
        sampleDivision = (int) (Math.random() * 20.0);
    }
}
