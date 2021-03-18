package com.hypersnare.dsp;

public class Snare implements PingSource {
    private Source noise;
    private Processor filter;
    private PingSource envelope;

    public Snare() {
        noise = new Noise();
        filter = new Filter();
        envelope = new PingEnv();
    }

    public void ping() {
        envelope.ping();
    }

    public double tick() {
        return filter.tick(noise.tick()) * envelope.tick();
    }
}
