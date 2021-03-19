package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

/**
 * A PingEnv is a PingSource that represents
 * a super simple linear decay envelope.
 */

public class PingEnv implements PingSource {
    public static double DECAY_LENGTH = 2;

    private double time;
    private double decayFactor;

    /**
     * Constructs a new default PingEnv
     */
    public PingEnv() {
        time = 0;
        decayFactor = 0.2;
    }

    /**
     * Pings the envelope, setting it to the
     * peak of its decay
     */
    public void ping() {
        time = 0;
    }

    /**
     * Ticks the envelope, getting its value
     * and moving it along its decay
     * @return the double of the envelope's value
     */
    public double tick() {
        time += 1.0 / ((double) StdAudio.SAMPLE_RATE);
        double value = 1.0 + -decayFactor * time;
        if (value > 0) {
            return value;
        } else {
            return 0;
        }
    }

    /**
     * Randomizes the decay of the envelope
     */
    public void randomize() {
        decayFactor = DECAY_LENGTH / (Math.random() + 0.0000001);
    }
}
