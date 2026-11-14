package org.group5;

import java.util.Scanner;

// all code is made by hand with no AI assitance, you can probably tell
// by how absurd it is lol, anyways, copyright maxthecomputerfox 2026

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // here we are using a concept similar
        // to a map, where each index of a character coresponds
        // to an index in the additions table where it will give
        // us an answer of how much cl  icks does that character takes

        /*
        so something like this:
        a -> 1 clicks
        b -> 2 clicks
        c -> 3 clicks

        This is done because some characters like s and z are part of groups consisting of
        4 members, meaning we cant just use the index and modulo without over complicating
        the logic (trust me I tried, and it was hell lmao).
        */

        //                                                                       S                    Z
        int[] additions = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("Enter your string: ");
        String userinput = scanner.nextLine();

        int counts = 0;

        for (int i = 0; i < userinput.length(); i++) {
            int index = alphabet.indexOf(userinput.charAt(i));

            if (index < 0) {
                // index will return -1 if the character doesnt exist.
                // if the character doesn't exist in the alphabet, that means it's
                // a character like space ' ' or a number '1' that usually takes
                // only one click, so we just increment counts and move on
                // to the next character

                counts++;
                continue;
            }

            // grab the amount of clicks it took by checking the additions array and
            // adding it to counts.
            counts += additions[index];
        }

        System.out.println(counts);
    }
}

