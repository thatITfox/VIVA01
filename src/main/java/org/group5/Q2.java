package org.group5;

import java.util.Scanner;

//Viva 1 Q2
public class Q2 {

    public static int reverse(int n) {
        int result = 0;

        while (n != 0) {
            int remainder = n % 10;
            //get the remainder
            result = result * 10 + remainder;
            //loop result be renew. *10 cz need place for another digit
            n = n / 10;
            //frm n,get a new n to continue the loop
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int n = input.nextInt();

        System.out.println("The input number is: " + n);
        System.out.println("After reversed: " + reverse(n));
    }
}
