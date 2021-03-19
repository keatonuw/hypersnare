package com.hypersnare.dsp;

// TODO: Implement some sort of bandpass filter algorithm.

/**
 * The Filter is a Processor that bandpass filters
 * for a given frequency
 */

public class Filter implements Processor {
    private double sample;

    public Filter() {
        sample = 0;
    }

    /**
     * Process a sample through the filter
     * @param in a double sample to process
     * @return a double of the now-processed sample
     */
    public void process(double in) {
        sample = in;
    }

    /**
     * Returns whatever was last in the buffer.
     * @return a double representing the last element in the
     * buffer.
     */
    public double tick() {
        return sample;
    }

    /**
     * Randomizes the state of the filter
     */
    public void randomize() {

    }
}
