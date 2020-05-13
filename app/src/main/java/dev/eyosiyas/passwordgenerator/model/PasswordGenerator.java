package dev.eyosiyas.passwordgenerator.model;

import java.util.Random;

public class PasswordGenerator {
    private final static String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private final static String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String numbers = "0123456789";
    private final static String symbols = "!@#$%^&*()_-+={}[]:;'|/><,.?";

    public String generate(int length) {
        String combination = String.format("%s%s%s%s", lowercase, uppercase, numbers, symbols);
        final StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            builder.append(combination.charAt(new Random().nextInt(combination.length())));
        return builder.toString();
    }
}