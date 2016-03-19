package ar.fiuba.tdd.template.helpers;

import ar.fiuba.tdd.template.model.Range;

import java.util.Random;

/**
 * Created by agustin on 18/03/16.
 */
public class RandomGenerator {

    public static int getRandomNumber(Range range) {
        Random random = new Random();
        int bound = range.getMax() - range.getMin();
        if (bound == 0) {
            return range.getMin();
        }
        return random.nextInt(bound + 1) + range.getMin();
    }

    public static String generateRandomSizeStringFromString(String values, Range sizeRange) {
        StringBuilder result = new StringBuilder();
        int randomSize = getRandomNumber(sizeRange);
        for (int i = 0; i < randomSize; i++) {
            result.append(String.valueOf(generateRandomCharacterFromString(values)));
        }
        return result.toString();
    }

    private static char generateRandomCharacterFromString(String value) {
        int randomNumber = getRandomNumber(new Range(0, value.length() - 1));
        return value.charAt(randomNumber);
    }

    public static String generateRandomSizeString(Range sizeRange) {
        StringBuilder result = new StringBuilder();
        int randomSize = getRandomNumber(sizeRange);
        for (int i = 0 ; i < randomSize ; i++) {
            result.append(generateRandomCharacter());
        }
        return result.toString();
    }

    private static char generateRandomCharacter() {
        int asciiValue = RandomGenerator.getRandomNumber(new Range(0,255));
        return (char) asciiValue;
    }
}
