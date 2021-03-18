package com.hypersnare.dsp;

public interface Processor extends Randomizeable {
    double tick(double in);
}
