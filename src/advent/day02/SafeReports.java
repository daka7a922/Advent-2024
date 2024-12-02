package day02;

import java.io.*;

public class SafeReports {

    public static void main(String[] args) throws IOException {

        int safeReportCount = countSafeReports("src/advent/day02/input.txt");
        System.out.println(safeReportCount);

    }

    private static int countSafeReports(String filePath) throws IOException {

        int safeReportCount = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {

            String[] tokens = line.split("\\s+");

            int[] tokensCount = new int[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                tokensCount[i] = Integer.parseInt(tokens[i]);
            }

            if (isSafeReport(tokensCount)) {
                safeReportCount++;
            }
        }
        return safeReportCount;
    }

    private static boolean isSafeReport(int[] tokensCount) {
        return checkIncreasingCount(tokensCount) || checkDecreasingCount(tokensCount);
    }

    private static boolean checkDecreasingCount(int[] tokensCount) {
        for (int i = 0; i < tokensCount.length - 1; i++) {
            int diff = tokensCount[i] - tokensCount[i + 1];
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIncreasingCount(int[] tokensCount) {
        for (int i = 0; i < tokensCount.length - 1; i++) {
            int diff = tokensCount[i + 1] - tokensCount[i];
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }
}
