package com.ichuvilin.passwordgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Password {

    private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String DIGITS = "123456789";
    private final String PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{}|~";

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

    public String passwordGenerate(int length) {

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

}
