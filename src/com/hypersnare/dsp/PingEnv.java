package com.hypersnare.dsp;

public class PingEnv implements PingSource {
    double time;
    double decayFactor;

    public PingEnv() {
        time = 0;
        decayFactor = 1.01;
    }

    public void ping() {
        time = 0;
    }

    public double tick() {
        time += 0.01;
        return Math.pow(decayFactor, -time);
    }
}
