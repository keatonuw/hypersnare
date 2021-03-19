package com.hypersnare.dsp;

/**
 * An interface that represents all
 * of the sources within this DSP set
 */

public interface Source {
    /**
     * Gets the current sample from the Source
     * @return a double of the sample
     */
    double tick();

    /**
     * Randomizes the values of the Source
     */
    void randomize();
}
