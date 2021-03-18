package com.hypersnare;

import com.hypersnare.dsp.Flanger;
import com.hypersnare.dsp.Snare;

import java.util.Scanner;

public class HyperSnare {

    public static void main(String[] args) {
        // prompt user to randomize, hear, or write a snare
        // randomize
        // hear
        // write
        Scanner input = new Scanner(System.in);

        Snare snare = new Snare();
        Flanger flang = new Flanger();
        double[] buffer = new double[0];

        System.out.println("Hello! Welcome to HyperSnare");
        int selection = promptAction(input);
        while (selection != 3) {
            if (selection == 0) {
                buffer = fillBuffer(snare, flang);
            } else if (selection == 1) {
                StdAudio.play(buffer);
            }
            selection = promptAction(input);
        }


        StdAudio.close();
        System.exit(0);
    }

    public static int promptAction(Scanner input) {
        promptAction();
        String choice = input.next();
        while (!(choice.equals("0") || choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
            promptAction();
            choice = input.next();
        }
        return Integer.parseInt(choice);
    }

    public static void promptAction() {
        System.out.println("What would you like to do? (Enter a number, 0-3)");
        System.out.println("0 - Randomize a snare");
        System.out.println("1 - Hear the current snare");
        System.out.println("2 - Save the current snare");
        System.out.println("3 - Quit");
    }

    public static double[] fillBuffer(Snare snare, Flanger flanger) {
        snare.randomize();
        flanger.randomize();
        double[] buffer = new double[StdAudio.SAMPLE_RATE];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = flanger.tick(snare.tick());
        }
        return buffer;
    }
}
