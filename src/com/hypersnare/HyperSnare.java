package com.hypersnare;

import com.hypersnare.dsp.Flanger;
import com.hypersnare.dsp.Snare;

import javax.sound.sampled.*;
import javax.xml.transform.Source;
import java.util.Arrays;

public class HyperSnare {

    public static void main(String[] args) {
        // prompt user to randomize, hear, or write a snare
        // randomize
        // hear
        // write
        Snare snare = new Snare();
        Flanger flang = new Flanger();

        snare.ping();
        for (int i = 0; i < StdAudio.SAMPLE_RATE; i++) {
            StdAudio.play(flang.tick(snare.tick()));
        }

        for (int j = 0; j < 5; j++) {
            flang.randomize();
            snare.randomize();
            snare.ping();
            for (int i = 0; i < StdAudio.SAMPLE_RATE; i++) {
                StdAudio.play(flang.tick(snare.tick()));
            }
        }

        StdAudio.close();
        System.exit(0);
    }
}