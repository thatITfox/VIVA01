package org.group5;

import java.util.Scanner;

// all code is made by hand with no AI assitance, you can probably tell
// by how absurd it is lol, anyways, copyright maxthecomputerfox 2026

public class Q6Recurse {

    public static int index = 0;

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
    public static int getReps(String pass, int indx) {

        int reps = 0;

        reps = pass.charAt(indx) - '0';

        if (Character.isDigit(pass.charAt(indx+1))) {
            reps *= 10;
            reps += pass.charAt(indx+1) - '0';
        }

        return reps;
    }

    /*
    The decompress function is the function doing the main logic for
    the password decompression. it loops through the password and adds each
    character to the result string.

    Anyways, on every level, if it detects the character '[' it will move to
    the next level, grab the reps needed for that level and call itself to
    decompress that specific sub string to add to its own result.

    Note: This is a newer version of Q6 after max had a very interesting
    shower thought. made just in case the judges ask for one made using
    recursion to go further than 3 levels of decompression.
    */
    public static String decompress(String pass, int reps) {

        String result = "";

        while (index < pass.length() && pass.charAt(index) != ']') {
            char passchar = pass.charAt(index);

            if (passchar == '[') {
                index++;
                int subreps = getReps(pass, index);
                if (subreps > 9) index++;

                index++;

                String substr = decompress(pass, subreps);

                result += substr;

                index++;
                continue;
            }

            result += passchar;
            index++;
        }

        for (int i = 1; i < reps; i++) result += result;
        // the reason why I made the i var start with one is because we're adding
        // an already existing sub string with itself. not a new empty string like before.

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(decompress(password, 1));
    }
}
