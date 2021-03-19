package com.hypersnare;

import com.hypersnare.dsp.Flanger;
import com.hypersnare.dsp.Snare;

import java.util.Scanner;

public class HyperSnare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Snare snare = new Snare();
        Flanger flang = new Flanger();
        double[] buffer = new double[StdAudio.SAMPLE_RATE];

        System.out.println("Hello! Welcome to HyperSnare");
        HyperSnareState state = promptAction(input);
        while (state != HyperSnareState.QUIT) {
            switch (state) {
                case RANDOMIZE:
                    System.out.println("Randomizing...");
                    System.out.println();
                    fillBuffer(buffer, snare, flang);
                    break;
                case LISTEN:
                    System.out.println("Playing...");
                    System.out.println();
                    StdAudio.play(buffer);
                    break;
                case SAVE:
                    System.out.println("Saving...");
                    System.out.println();
                    // TODO: Prompt user for filename, then save.
                    break;
                case QUIT:
                    break;
            }
            state = promptAction(input);
        }


        StdAudio.close();
        System.exit(0);
    }

    public static HyperSnareState promptAction(Scanner input) {
        promptAction();
        String choice = input.next();
        while (!(choice.equals("0") || choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
            promptAction();
            choice = input.next();
        }
        return HyperSnareState.values()[(Integer.parseInt(choice))];
    }

    public static void promptAction() {
        System.out.println("What would you like to do? (Enter a number, 0-3)");
        System.out.println("0 - Randomize a snare");
        System.out.println("1 - Hear the current snare");
        System.out.println("2 - Save the current snare");
        System.out.println("3 - Quit");
    }

    public static void fillBuffer(double[] buffer, Snare snare, Flanger flanger) {
        snare.randomize();
        flanger.randomize();
        snare.ping();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = flanger.tick(snare.tick());
        }
    }

    public enum HyperSnareState {
        RANDOMIZE,
        LISTEN,
        SAVE,
        QUIT
    }


}
