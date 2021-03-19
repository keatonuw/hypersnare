package com.hypersnare.dsp;

import java.util.LinkedList;
import java.util.Queue;

public class HyperChain implements Processor {
    private static final int MAX_EFFECTS = 20;

    private Queue<Processor> effects;
    private double sample;

    /**
     * Creates a default HyperChain
     */
    public HyperChain() {
        effects = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            effects.add(new Flanger());
        }
        sample = 0;
    }
    /**
     * Processes the incoming signal, and
     * returns a new value
     *
     * @param in a double to process
     * @return a double of what has been processed
     */
    public void process(double in) {
        int size = effects.size();
        for (int i = 0; i < size; i++) {
            Processor effect = effects.remove();
            effect.process(in);
            in = in * 0.5 + effect.tick() * 0.5;
            effects.add(effect);
        }
        sample = in;
    }

    /**
     * Gets the current sample from the chain front
     *
     * @return a double of the sample
     */
    public double tick() {
        return sample;
    }

    /**
     * Randomizes the chain
     */
    public void randomize() {
        while (!effects.isEmpty()) {
            effects.remove();
        }
        int size = (int) (Math.random() * MAX_EFFECTS);
        for (int i = 0; i < size; i++) {
            int effectType = (int) (Math.random() * 4.0);
            Processor effect;
            if (effectType == 3) {
                effect = new BitCrusher();
            } else if (effectType == 2) {
                effect = new Delay();
            } else if (effectType == 1) {
                effect = new Flanger();
            } else {
                effect = new Saturator();
            }
            effect.randomize();
            effects.add(effect);
        }
    }
}
