package org.group5;

import java.util.Scanner;

// all code is made by hand with no AI assitance, you can probably tell
// by how absurd it is lol, anyways, copyright maxthecomputerfox 2026

public class Q6 {
    /*
    The GetReps function basically takes in the password string and an index
    of where the repetitions number starts or the D in [DX]. it first grabs
    the first character at the index and convert it to an int, then checks if
    the character after our first character is a digit. if so, that means that
    the D is in the tens, so we multiply our first digit by 10 and add the
    now converted to int seccond character so we get the actual first unit digit.

    [2AB], reps = 2
    [23AB], reps = 2*10 + 3;

    I did this because the number is always between 1 and 99. Meaning the amount
    of characters to check will always be less than 3.
    */
    public static int getReps(String pass, int index) {

        int reps = 0;

        reps = pass.charAt(index) - '0';

        if (Character.isDigit(pass.charAt(index+1))) {
            reps *= 10;
            reps += pass.charAt(index+1) - '0';
        }

        return reps;
    }

    /*
    The decompress function is the function doing the main logic for
    the password decompression. it loops through the password and adds each
    character to the result string. now there are in total 3 nested loops
    because the max compression levels is 3, meaning we don't have to use
    advance concepts like stacks and recursions to parse multiple substrings
    consisting of very deep levels (the author of this code "Vajra" is an ex
    competitive programmer so he has been through things like this lol).

    Anyways, on every level, if it detects the character '[' it will move to
    the next level, grab the reps needed for that level and go to a nested loop
    to generate the substring and concatenate it x times with x being the amount
    of reps grabbed.
    */
    public static String decompress(String pass) {
        int index = 0;
        String result = "";

        while (index < pass.length()) {
            char passchar = pass.charAt(index);

            // level 1 compression
            if (passchar == '[') {
                index++; // move the index to start of D of [DX]
                int reps = getReps(pass, index);
                // if reps is bigger than 9, that means the start of the
                // substring is more infront.
                if (reps > 9) index++; // move index to the second character of D.

                index++; // moves index to the actual start of the substring.

                String substringone = "";
                while (pass.charAt(index) != ']') {
                    passchar = pass.charAt(index);

                    // level 2 compression
                    // for comments on the next levels such as this level and level 3,
                    // please refer back to line 59 where I explain what happens beacuse
                    // the process is basically the same.
                    if (passchar == '[') {
                        index++;
                        int reps2 = getReps(pass, index);
                        if (reps2 > 9) index++;

                        index++;

                        String substringtwo = "";

                        while (pass.charAt(index) != ']') {
                            passchar = pass.charAt(index);

                            // level 3 compression
                            if (passchar == '[') {
                                index++;
                                int reps3 = getReps(pass, index);
                                if (reps3 > 9) index++;

                                index++;

                                String substring3 = "";

                                while (pass.charAt(index) != ']') {
                                    passchar = pass.charAt(index);

                                    // because level 3 is the last/deepest level, we don't
                                    // have to dig deeper anymore to decompress deeper
                                    // levels

                                    substring3 += passchar;
                                    index++;
                                }

                                // do the 3rd layer string multiplication
                                for (int i = 0; i < reps3; i++) substringtwo += substring3;
                            }

                            substringtwo += passchar;
                            index++;
                        }

                        // do the 2nd layer string multiplication
                        for (int i = 0; i < reps2; i++) substringone += substringtwo;

                        index++;
                        continue;
                    }

                    substringone += passchar;
                    index++;
                }

                // do the string multiplication
                for (int i = 0; i < reps; i++) result += substringone;

                // moves the character to after ']' and continue work as usual
                index++;
                continue;
            }

            // concatenate the character we grabbed to the result string.
            result += passchar;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(decompress(password));
    }
}
