package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

import java.util.LinkedList;
import java.util.Queue;

public class Delay implements Processor {
    private Queue<Double> buffer;
    private double feedback;

    /**
     * Constructs a new Delay with default
     * values
     */
    public Delay() {
        buffer = new LinkedList<>();
        feedback = 0.5;
        int bufferSize = StdAudio.SAMPLE_RATE;
        for (int i = 0; i < bufferSize; i++) {
            buffer.add(0.0);
        }
    }

    /**
     * Processes the given sample through the
     * delay
     * @param in a double to process
     * @return a double of the newly process sound
     */
    public double tick(double in) {
        double sample = buffer.remove();
        buffer.add(in * (1.0 - feedback) + sample * feedback);
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
     * Randomizes the settings of the delay
     */
    public void randomize() {
        feedback = Math.random() * 0.5;
        int newSize = 1 + (int) (Math.random() * (StdAudio.SAMPLE_RATE / 2));
        while (buffer.size() != newSize) {
            if (buffer.size() > newSize) {
                buffer.remove();
            } else if (buffer.size() < newSize) {
                buffer.add(0.0);
            }
        }
    }
}
