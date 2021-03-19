package com.hypersnare.dsp;

/**
 * An interface used to define Sources that
 * can process incoming signals
 */

public interface Processor extends Source {
    /**
     * Processes the incoming signal, and
     * returns a new value
     * @param in a double to process
     * @return a double of what has been processed
     */
    void process(double in);
}
