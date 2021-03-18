package com.hypersnare.dsp;

import com.hypersnare.StdAudio;

public class Tone implements Source {
    private double time;
    private double frequency;

    public Tone() {
        time = 0;
        frequency = 440;
    }

    public double tick() {
        time++;
        if (time > StdAudio.SAMPLE_RATE) {
            time = 0;
        }
        return Math.sin(time * frequency);
    }

    public void randomize() {
        frequency = Math.random() * 22000 + 220;
    }
}
