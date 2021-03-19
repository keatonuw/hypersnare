package com.hypersnare.dsp;

public class Snare implements PingSource {
    private Source noise;
    private Source tone;
    private Processor filter;
    private PingSource envelope;

    private double noiseVolume;
    private double toneVolume;

    public Snare() {
        noise = new Noise();
        tone = new Tone();
        filter = new Filter();
        envelope = new PingEnv();
        noiseVolume = 0.5;
        toneVolume = 0.5;
    }

    public void randomize() {
        noiseVolume = Math.random() * 0.75 + 0.25;
        toneVolume = 1.0 - noiseVolume;
        noise.randomize();
        tone.randomize();
        filter.randomize();
        envelope.randomize();
    }

    public void ping() {
        envelope.ping();
    }

    public double tick() {
        double sound = noiseVolume * noise.tick() + toneVolume * tone.tick();
        sound = filter.tick(sound) * envelope.tick();
        return sound;
    }
}
