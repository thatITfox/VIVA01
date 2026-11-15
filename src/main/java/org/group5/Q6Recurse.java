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
                index++; // move the index to start of D of [DX]
                int subreps = getReps(pass, index);
                // if reps is bigger than 9, that means the start of the
                // substring is more in front.
                if (subreps > 9) index++;

                index++; // moves index to the actual start of the substring.

                // starts the next level of decompression
                String substr = decompress(pass, subreps);

                // appends the decompresses string to result
                result += substr;

                // moves the index pointer after the ']' character
                index++;
                continue;
            }

            result += passchar;
            index++;
        }

        // does the repetition or decompression.
        String fullres = "";
        for (int i = 0; i < reps; i++) fullres += result;

        return fullres;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(decompress(password, 1));
    }
}
