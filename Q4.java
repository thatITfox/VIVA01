import java.util.Scanner;

public class Q4 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        /*
        String s = "luogu";

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                System.out.println(s.substring(start, end) + " " + (start + 1) + " " + end);
            }
        }

         */

        /*
        String s = "luogu";
        String best = "";
        boolean found = false;

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                String sub = s.substring(start, end);

                if (!found || sub.compareTo(best) < 0) {
                    best = sub;
                    found = true;
                }
            }
        }

        System.out.println(best);

         */

        /*
        String s = "luogu";
        String best = "";
        int bestStart = 0;
        int bestEnd = 0;
        boolean found = false;

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                String sub = s.substring(start, end);

                if (!found || sub.compareTo(best) < 0) {
                    best = sub;
                    bestStart = start;
                    bestEnd = end;
                    found = true;
                }
            }
        }

        System.out.println(best + " " + (bestStart + 1) + " " + bestEnd);

         */




        /*
        String s = "luogu";

        String lastSub = "g";   // the piece we printed last
        int lastStart = 3;      // where it started (Java counting)

        String best = "";
        int bestStart = 0;
        int bestEnd = 0;
        boolean found = false;

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                String sub = s.substring(start, end);

                // new rule: is this piece after the last printed one?
                boolean afterLast = sub.compareTo(lastSub) > 0
                        || (sub.compareTo(lastSub) == 0 && start > lastStart);

                if (afterLast) {
                    if (!found || sub.compareTo(best) < 0) {
                        best = sub;
                        bestStart = start;
                        bestEnd = end;
                        found = true;
                    }
                }
            }
        }

        System.out.println(best + " " + (bestStart + 1) + " " + bestEnd);

         */
        String s = scanner.next();

        int n = s.length();
        int total = n * (n + 1) / 2;

        String lastSub = "";
        int lastStart = -1;

        for (int round = 0; round < total; round++) {

            String bestSub = "";
            int bestStart = -1;
            int bestEnd = -1;
            boolean found = false;

            for (int start = 0; start < n; start++) {
                for (int end = start + 1; end <= n; end++) {
                    String sub = s.substring(start, end);

                    // is this piece after the last printed one?
                    boolean afterLast = sub.compareTo(lastSub) > 0
                            || (sub.compareTo(lastSub) == 0 && start > lastStart);

                    if (afterLast) {
                        // is it better than the best one so far?
                        boolean better = !found
                                || sub.compareTo(bestSub) < 0
                                || (sub.compareTo(bestSub) == 0 && start < bestStart);

                        if (better) {
                            bestSub = sub;
                            bestStart = start;
                            bestEnd = end;
                            found = true;
                        }
                    }
                }
            }

            System.out.println(bestSub + " " + (bestStart + 1) + " " + bestEnd);
            lastSub = bestSub;
            lastStart = bestStart;
        }

        scanner.close();

    }
}
