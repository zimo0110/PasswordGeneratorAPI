package com.example.passwordGenerator.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStrengthMeter {
    public String calc(String password) {
        int strength = measurePasswordStrength(password);
        return categorizePasswordStrength(strength);

    }

    private static int measurePasswordStrength(String password) {
        // Basic metrics
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        // Entropy
        double entropy = calculateEntropy(password);

        // Combine metrics to determine strength
        int strength = 0;

        if (hasUppercase) strength++;
        if (hasLowercase) strength++;
        if (hasDigit) strength++;
        if (hasSpecialChar) strength++;

        // Bonus points for high entropy
        if (entropy >= 4.0) strength++;

        return strength;
    }

    private static double calculateEntropy(String password) {
        // Calculate entropy based on the number of unique characters
        double entropy = 0;
        int length = password.length();
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(password);

        while (matcher.find()) {
            int groupLength = matcher.group().length();
            double probability = (double) groupLength / length;
            entropy -= probability * Math.log(probability) / Math.log(2);
        }
        return entropy;
    }

    private static String categorizePasswordStrength(int strength) {
        if (strength >= 5) {
            return "Very Secure";
        } else if (strength >= 3) {
            return "Secure";
        } else if (strength >= 1) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}

