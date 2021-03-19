package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Flanger is a Processor that works as a super
 * short delay line, bringing the processing into
 * audio-rate territory, acting almost like a Karplus
 * Strong resonator
 */

public class Flanger implements Processor {
    private Queue<Double> buffer;
    private double feedback;

    /**
     * Constructs a new Flanger with default
     * values
     */
    public Flanger() {
        buffer = new LinkedList<>();
        feedback = 0.5;
        int bufferSize = (int) (Math.round(StdAudio.SAMPLE_RATE / 440));
        for (int i = 0; i < bufferSize; i++) {
            buffer.add(0.0);
        }
    }

    /**
     * Processes the given sample through the
     * flanger
     * @param in a double to process
     * @return a double of the newly process sound
     */
    public double tick(double in) {
        double sample = buffer.remove();
        buffer.add(in + sample * feedback);
        return sample;
    }

    /**
     * Reveals the front of the buffer
     * @return double of the front of the buffer
     */
    public double tick() {
        return buffer.peek();
    }

    /**
     * Randomizes the settings of the flanger
     */
    public void randomize() {
        feedback = Math.random() * 0.9;
        int newSize = 1 + (int) (Math.random() * Math.round(StdAudio.SAMPLE_RATE / 440));
        while (buffer.size() != newSize) {
            if (buffer.size() > newSize) {
                buffer.remove();
            } else if (buffer.size() < newSize) {
                buffer.add(0.0);
            }
        }
    }
}
