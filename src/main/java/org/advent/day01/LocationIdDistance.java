package org.advent.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationIdDistance {

    public static void main(String[] args) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/advent/day01/input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                leftList.add(Integer.parseInt(parts[0]));
                rightList.add(Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        long totalDistance = calculateTotalDistance(leftList, rightList);
        System.out.println("Total distance between lists: " + totalDistance);
    }

    public static long calculateTotalDistance(List<Integer> leftList, List<Integer> rightList) {

        List<Integer> leftSorted = new ArrayList<>(leftList);
        List<Integer> rightSorted = new ArrayList<>(rightList);
        Collections.sort(leftSorted);
        Collections.sort(rightSorted);

        int maxLength = Math.max(leftSorted.size(), rightSorted.size());
        while (leftSorted.size() < maxLength) {
            leftSorted.add(0);
        }
        while (rightSorted.size() < maxLength) {
            rightSorted.add(0);
        }

        long totalDistance = 0;
        for (int i = 0; i < maxLength; i++) {
            totalDistance += Math.abs(leftSorted.get(i) - rightSorted.get(i));
        }

        return totalDistance;
    }
}