package com.hypersnare.dsp;

import java.util.LinkedList;
import java.util.Queue;

public class HyperChain implements Processor {
    private static final int MAX_EFFECTS = 10;
    
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
        while (!effects.isEmpty()) {
            effects.remove();
        }
        int size = (int) (Math.random() * MAX_EFFECTS);
        for (int i = 0; i < size; i++) {
            Processor effect = new Flanger();
            effect.randomize();
            effects.add(effect);
        }
    }
}
