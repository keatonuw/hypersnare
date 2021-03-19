package com.hypersnare.dsp;

import java.util.LinkedList;
import java.util.Queue;

public class HyperChain implements Processor {
    private Queue<Processor> effects;

    /**
     * Creates a default HyperChain
     */
    public HyperChain() {
        effects = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            effects.add(new Flanger());
        }
    }
    /**
     * Processes the incoming signal, and
     * returns a new value
     *
     * @param in a double to process
     * @return a double of what has been processed
     */
    public double tick(double in) {
        int size = effects.size();
        for (int i = 0; i < size; i++) {
            Processor effect = effects.remove();
            in = in * 0.5 + effect.tick(in) * 0.5;
            effects.add(effect);
        }
        return in;
    }

    /**
     * Gets the current sample from the chain front
     *
     * @return a double of the sample
     */
    public double tick() {
        return effects.peek().tick();
    }

    /**
     * Randomizes the chain
     */
    public void randomize() {
        int size = effects.size();
        for (int i = 0; i < size; i++) {
            Processor effect = effects.remove();
            effect.randomize();
            effects.add(effect);
        }
    }
}
