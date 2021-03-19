package com.hypersnare;

import com.hypersnare.dsp.*;

import java.util.LinkedList;
import java.util.Queue;

public class HyperSnare {
    public static final int MAX_SAMPLES = StdAudio.SAMPLE_RATE;
    public static final int NOISE_GATE_THRESH = 100;

    private PingSource snare;
    private Processor effects;
    private Queue<Double> buffer;

    /**
     * Constructs a default HyperSnare
     */
    public HyperSnare() {
        snare = new Snare();
        effects = new HyperChain();
        buffer = new LinkedList<>();
    }

    /**
     * Generates a snare sound, which is stored in the
     * HyperSnare's queue.
     */
    public void generateSnare() {
        while (!buffer.isEmpty()) {
            buffer.remove();
        }

        snare.randomize();
        effects.randomize();
        snare.ping();

        int noiseGateCount = 0;
        while (buffer.size() < MAX_SAMPLES && noiseGateCount < NOISE_GATE_THRESH) {
            effects.process(snare.tick());
            double sample = effects.tick();
            buffer.add(sample);
            if (sample == 0) {
                noiseGateCount++;
            } else {
                noiseGateCount = 0;
            }
        }
    }

    /**
     * Gets the current buffer of samples as an array
     * of doubles.
     *
     * @return a double array of the samples in the buffer
     */
    public double[] getSnare() {
        double[] samples = new double[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            samples[i] = buffer.remove();
            buffer.add(samples[i]);
        }
        return samples;
    }
}
