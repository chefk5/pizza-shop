package org.chefk5.pizzashop.utils;

import java.util.Random;

public class generatorsUtil {

    private generatorsUtil() {
    }

    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "mail.com", "example.com"};
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";

        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate username with a length of 6 to 12 characters
        int usernameLength = 6 + random.nextInt(7);
        for (int i = 0; i < usernameLength; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Append domain
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }

    public static String generateRandomUsername() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Allowed characters
        Random random = new Random();

        // Generate username length (6 to 12 characters)
        int usernameLength = 6 + random.nextInt(7);

        StringBuilder username = new StringBuilder();
        for (int i = 0; i < usernameLength; i++) {
            username.append(characters.charAt(random.nextInt(characters.length())));
        }

        return username.toString();
    }

    public static String generateRandomPassword(int length) {
        // Character set for the password
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_+=<>?/{}[]~";
        String allowedCharacters = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;

        Random random = new Random();

        // Ensure the password contains at least one character from each set
        StringBuilder password = new StringBuilder();
        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Fill the remaining length of the password with random characters
        for (int i = 4; i < length; i++) {
            password.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }

        // Shuffle the password to avoid predictable patterns
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            // Swap characters
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }


}
