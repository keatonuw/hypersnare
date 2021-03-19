package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

public class PingEnv implements PingSource {
    double time;
    double decayFactor;

    public PingEnv() {
        time = 0;
        decayFactor = 0.2;
    }

    public void ping() {
        time = 0;
    }

    public double tick() {
        time += 1.0 / ((double) StdAudio.SAMPLE_RATE);
        double value = 1.0 + -decayFactor * time;
        if (value > 0) {
            return value;
        }
        return 0;
    }

    public void randomize() {
        decayFactor = 1 / (Math.random() + 0.001);
    }
}
