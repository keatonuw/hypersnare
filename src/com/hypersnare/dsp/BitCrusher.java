package com.hypersnare.dsp;

public class BitCrusher implements Processor {
    private double sample;
    private int sampleDivision;
    private int count;

    /**
     * Creates a default BitCrusher
     */
    public BitCrusher() {
        sample = 0;
        sampleDivision = 1;
        count = 0;
    }

    /**
     * Processes the incoming signal, and
     * returns a new bitcrushed value
     *
     * @param in a double to process
     * @return a double of what has been processed
     */
    public void process(double in) {
        count++;
        if (count >= sampleDivision) {
            count = 0;
            sample = in;
        }
    }

    /**
     * Gets the current sample from the BitCrusher
     *
     * @return a double of the sample
     */
    public double tick() {
        return sample;
    }

    /**
     * Randomizes the values of the BitCrusher
     */
    public void randomize() {
        sampleDivision = (int) (Math.random() * 20.0);
    }
}
