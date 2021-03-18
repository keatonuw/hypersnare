package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

import java.util.LinkedList;
import java.util.Queue;

public class Flanger implements Processor {
    private Queue<Double> buffer;
    private double feedback;

    public Flanger() {
        buffer = new LinkedList<>();
        feedback = 0.5;
        int bufferSize = (int)(Math.round(StdAudio.SAMPLE_RATE / 440));
        for (int i = 0; i < bufferSize; i++) {
            buffer.add(0.0);
        }
    }

    public double tick(double in) {
        double sample = buffer.remove();
        buffer.add(in + sample * feedback);
        return sample;
    }

    public void randomize() {
        feedback = Math.random() * 0.9;
        int newSize = (int) (Math.random() * Math.round(StdAudio.SAMPLE_RATE / 440));
        while (buffer.size() != newSize) {
            if (buffer.size() > newSize) {
                buffer.remove();
            } else if (buffer.size() < newSize) {
                buffer.add(0.0);
            }
        }
    }
}
