package com.service;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    // Private constructor to prevent instantiation
    private RandomNumberGenerator() {
    }

    /**
     * Generates a random integer within the specified range (inclusive).
     *
     * @param min The minimum value of the range (inclusive).
     * @param max The maximum value of the range (inclusive).
     * @return A random integer within the specified range.
     */
    public static int generateRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range: min should be less than or equal to max");
        }

        // The formula for generating a random number within a range: [min, max]
        return random.nextInt((max - min) + 1) + min;
    }
}

