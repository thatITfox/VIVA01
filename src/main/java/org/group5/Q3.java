package org.group5;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter string: ");
        String s = in.nextLine();
        System.out.print("enter L: ");
        long L = in.nextLong();
        if (L > (Math.pow(10, 6))) {
            System.out.println("too much");
            return;
        }
        int[] freq = new int[128];
        int freq1 = freq[0];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (freq[i] > freq1) {
                freq1 = freq[i];
            }
        }
        long lnow = s.length();
        int ope = 0;
        while (lnow < L) {
            lnow += freq1;
            freq1 *= 2;
            ope++;
        }
        System.out.println(ope);
        in.close();
    }
}
