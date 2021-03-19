package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

/**
 * Tone is a Source that generates a sine wave
 * tone
 */

public class Tone implements Source {
    private double time;
    private double frequency;

    /**
     * Creates a default Tone
     */
    public Tone() {
        time = 0;
        frequency = 440;
    }

    /**
     * Gets the sample of the tone
     * @return a double of the sample
     */
    public double tick() {
        time++;
        if (time > StdAudio.SAMPLE_RATE) {
            time = 0;
        }
        return Math.sin(2 * Math.PI * frequency * time / ((double) StdAudio.SAMPLE_RATE));
    }

    /**
     * Randomizes the pitch of the tone
     */
    public void randomize() {
        frequency = Math.random() * 22000.0 + 220.0;
    }
}
