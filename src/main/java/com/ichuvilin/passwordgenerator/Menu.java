package com.ichuvilin.passwordgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner scan = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("Choose one options on list:\n" +
                "1. Generate new password\n" +
                "2. Check password strength\n" +
                "3. Quit");
        String ans = scan.nextLine();
        switch (ans) {
            case "1" -> generatePassword();
            case "2" -> System.out.println("2");
            case "3" -> System.exit(1);
            default -> throw new UnsupportedOperationException("Unsupported options");
        }
    }

    private void generatePassword() {
        System.out.print("Use Upper letter [true/false]: ");
        boolean useUpper = scan.nextBoolean();
        System.out.print("Use Lower letter [true/false]: ");
        boolean useLower = scan.nextBoolean();
        System.out.print("Use Digits letter [true/false]: ");
        boolean useDigits = scan.nextBoolean();
        System.out.print("Use Punctuation letter [true/false]: ");
        boolean usePunctuation = scan.nextBoolean();
        System.out.print("Enter length password: ");
        int length = scan.nextInt();
        Password pw = new Password(useUpper, useLower, useDigits, usePunctuation);
        String passwd = pw.passwordGenerate(length);
        scan.nextLine();
        System.out.println(passwd);
    }

}
