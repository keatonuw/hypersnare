package com.hypersnare;

import com.hypersnare.dsp.HyperChain;
import com.hypersnare.dsp.Processor;
import com.hypersnare.dsp.Snare;

import java.util.Queue;
import java.util.Scanner;

/**
 * The main client class for HyperSnare.
 */

public class HyperSnareGenerator {

    /**
     * Prompts user interaction to generate, play, and
     * save snares.
     *
     * @param args user arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HyperSnare snare = new HyperSnare();

        System.out.println("Hello! Welcome to HyperSnare");
        HyperSnareState state = promptAction(input);
        while (state != HyperSnareState.QUIT) {
            switch (state) {
                case RANDOMIZE:
                    System.out.println("Randomizing...");
                    System.out.println();
                    snare.generateSnare();
                    break;
                case LISTEN:
                    System.out.println("Playing...");
                    System.out.println();
                    StdAudio.play(snare.getSnare());
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

    /**
     * Prompts the user to select a state.
     *
     * @param input the Scanner to get input from
     * @return a new HyperSnareState, as selected
     */
    public static HyperSnareState promptAction(Scanner input) {
        promptAction();
        String choice = input.next();
        while (!(choice.equals("0") ||
                choice.equals("1") ||
                choice.equals("2") ||
                choice.equals("3"))) {
            promptAction();
            choice = input.next();
        }
        return HyperSnareState.values()[(Integer.parseInt(choice))];
    }

    /**
     * Prints the action menu.
     */
    public static void promptAction() {
        System.out.println("What would you like to do? (Enter a number, 0-3)");
        System.out.println("0 - Randomize a snare");
        System.out.println("1 - Hear the current snare");
        System.out.println("2 - Save the current snare");
        System.out.println("3 - Quit");
    }

    /**
     * A enum representation of the program state.
     */
    public enum HyperSnareState {
        RANDOMIZE,
        LISTEN,
        SAVE,
        QUIT
    }


}
