package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

import java.util.LinkedList;
import java.util.Queue;

public class Flanger implements Processor {
    private Queue<Double> buffer;
    private double frequency;

    public Flanger() {
        buffer = new LinkedList<>();
        frequency = 440;
        int bufferSize = (int)(Math.round(StdAudio.SAMPLE_RATE / frequency));
        for (int i = 0; i < bufferSize; i++) {
            buffer.add(0.0);
        }
    }

    public double tick(double in) {
        double sample = buffer.remove();
        buffer.add((sample + in) / 2.0);
        return sample;
    }
}
