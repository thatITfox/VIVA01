package org.group5;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter ISBN code: ");
        String code = in.nextLine().trim();
        /*
        trim removes spaces in case you/your keyboard
        accidentally puts spaces at the end of your code
         */
        if (code.length() < 13 || code.charAt(1) != '-' || code.charAt(5) != '-' || code.charAt(11) != '-') {
            System.out.println("wrong format, run again.");
            return;
        }

        int last;
        if (code.charAt(code.length() - 1) == 'X' || code.charAt(code.length() - 1) == 'x') {
            last = 10;
        } else {
            last = Character.getNumericValue(code.charAt(code.length() - 1));
            /*
            for every Character.getNumericValue we are changing a char
            into an int/double depending on what type you are
            assiging the obtained value to: int last means it's ging to be an int
            */
        }

        String t = code.replace("-", "");
        int check = 0;
        for (int i = 0; i < 9; i++) {
            check += (Character.getNumericValue(t.charAt(i)) * (i + 1));
        }
        int remainder = check % 11;
        String correctCheck;
        if (remainder == 10) {
            correctCheck = "X";
        } else {
            correctCheck = String.valueOf(remainder);
            // turning the value of the remainder into a string
        }
        if (remainder == last) {
            System.out.println("Right");
        } else {
            String correctedCode = code.substring(0, 12) + correctCheck;
            System.out.println(correctedCode);
        }
    }
}
/* code.substring copies a certain part of the string in the bounds. In this
case we are taking all the characters of the isbn code entered 
except for the incorrect check and adding the correctCheck string to the end,
essentially replacing the error check*/