package org.advent.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimilarityCheck {

    public static void main(String[] args) throws IOException {

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/advent/day01/input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                leftList.add(Integer.parseInt(parts[0]));
                rightList.add(Integer.parseInt(parts[1]));
            }

        long similarityScore = findCommonElements(leftList, rightList);
        System.out.println(similarityScore);

    }

    public static long findCommonElements(List<Integer> left, List<Integer> right) {
        long totalSimilarityScore = 0;

        int counter = 0;
        for (int i = 0; i < left.size(); i++) {
            long similarityScore = 0;

            int element = left.get(i);
            for (int j = 0; j < right.size(); j++) {
                if (element == right.get(j)) {
                    counter++;
                }
            }

            similarityScore += (long) counter * element;
            totalSimilarityScore += similarityScore;
            counter = 0;

        }

        return totalSimilarityScore;
    }

}
