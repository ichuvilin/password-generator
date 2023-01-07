package com.ichuvilin.passwordgenerator;

import java.util.*;

public class Password {

    private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String DIGITS = "123456789";
    private final String PUNCTUATION = "!@#\\$%&\\*()_\\+=|<>\\?\\{}\\[\\]~-";

    private boolean useUpper;
    private boolean useLower;
    private boolean useDigits;
    private boolean usePunctuation;

    public Password(boolean useUpper, boolean useLower, boolean useDigits, boolean usePunctuation) {
        this.useUpper = useUpper;
        this.useLower = useLower;
        this.useDigits = useDigits;
        this.usePunctuation = usePunctuation;
    }

    public Password() {
    }


    public String passwordGenerate(int length) {
        if (useUpper || useLower || useDigits || usePunctuation) {
            if (length <= 0) return "";

            StringBuilder sb = new StringBuilder();
            List<String> charCategories = new ArrayList<>(4);
            Random random = new Random(System.nanoTime());

            if (useUpper) charCategories.add(UPPER);
            if (useLower) charCategories.add(LOWER);
            if (useDigits) charCategories.add(DIGITS);
            if (usePunctuation) charCategories.add(PUNCTUATION);

            for (int i = 0; i < length; i++) {
                String charCategory = charCategories.get(random.nextInt(charCategories.size()));
                int position = random.nextInt(charCategory.length());
                sb.append(charCategory.charAt(position));
            }

            return new String(sb);
        }
        return "Wrong data";
    }

    public void passwordStrength(String password) {
        Map<String, String> map = new HashMap<>();
        map.put("Password Length", passwordLength(password.length()));
        map.put("use upper latter", String.valueOf(password.matches("^(?=.*[A-Z]).+$")));
        map.put("use lower latter", String.valueOf(password.matches("^(?=.*[a-z]).+$")));
        map.put("use digits", String.valueOf(password.matches("^(?=.*\\d).+$")));
        map.put("use punctuation", String.valueOf(password.matches("^(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-]).+$")));
        generatedReport(map, password.length());
    }

    private void generatedReport(Map<String, String> map, int length) {
        System.out.printf("Password Length: %d - %s\n", length, map.get("Password Length"));
        System.out.printf("Use Upper latter: %s\n", map.get("use upper latter"));
        System.out.printf("Use Lower latter: %s\n", map.get("use lower latter"));
        System.out.printf("Use Digits: %s\n", map.get("use digits"));
        System.out.printf("Use Punctuation: %s\n", map.get("use punctuation"));
    }

    private String passwordLength(int length) {
        if (length > 0 && length <= 6) return "OK";
        if (length >= 7 && length <= 15) return "GOOD";
        if (length >= 16) return "GREAT";
        return "";
    }

}
