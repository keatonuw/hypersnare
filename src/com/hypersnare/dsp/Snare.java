package com.hypersnare.dsp;

/**
 * A Snare is a PingSource that contains
 * several sources and processors to synthesize
 * a simple subtractive snare sound
 */

public class Snare implements PingSource {
    private Source noise;
    private Source tone;
    private Processor filter;
    private PingSource envelope;

    private double noiseVolume;
    private double toneVolume;

    /**
     * Creates a Snare with default
     * parameters
     */
    public Snare() {
        noise = new Noise();
        tone = new Tone();
        filter = new Filter();
        envelope = new PingEnv();
        noiseVolume = 0.5;
        toneVolume = 0.5;
    }

    /**
     * Randomizes the parameters of the
     * snare
     */
    public void randomize() {
        noiseVolume = Math.random() * 0.75 + 0.25;
        toneVolume = 1.0 - noiseVolume;
        noise.randomize();
        tone.randomize();
        filter.randomize();
        envelope.randomize();
    }

    /**
     * Pings the snare, setting it up to
     * make sound when ticked
     */
    public void ping() {
        envelope.ping();
    }

    /**
     * Ticks the snare, getting its
     * current sample value
     * @return a double of the current sample
     */
    public double tick() {
        double sound = noiseVolume * noise.tick() + toneVolume * tone.tick();
        filter.process(sound);
        sound = filter.tick() * envelope.tick();
        return sound;
    }
}
