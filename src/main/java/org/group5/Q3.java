package org.group5;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter string: ");
        String s = in.nextLine();
        System.out.print("enter L: ");
        long L = in.nextLong();
        in.nextLine(); 
       /* if (L > (Math.pow(10, 6))) {
            System.out.println("too much");
            return;
                } 
        // this is for subtask 3, it just says L must not be 
        more that 10^6,that's all        */
        /* if (s.length()!=(L-1)){
       System.out.print("|S| must be equal to L-1");
       return; }
       // this is for subtask 1*/
        int[] freq = new int[128];
                for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        
        System.out.print("choose a character: ");
        String choice= in.nextLine();
         char chosenChar = choice.charAt(0); 
                long currentFreq = freq[chosenChar];
        long lnow = s.length();
        int ope = 0;
        while (lnow < L) {
            lnow += currentFreq;
            currentFreq *= 2;
            ope++;
        }
        System.out.println(ope);
        in.close();
    }
}
