package com.hypersnare.dsp;

public interface Processor extends Source {
    double tick(double in);
}
