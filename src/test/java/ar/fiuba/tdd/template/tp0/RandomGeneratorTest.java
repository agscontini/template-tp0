package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.helpers.RandomGenerator;
import ar.fiuba.tdd.template.model.Range;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;


/**
 * Created by agustin on 19/03/16.
 */
public class RandomGeneratorTest {

    private int getRandomNumberInRange(int min, int max) {
        Range range = new Range(min,max);
        return RandomGenerator.getRandomNumber(range);
    }

    private Matcher getMatcherFromRegEx(String regEx, String stringToEvaluate) {
        Pattern pattern = Pattern.compile(regEx);
        return pattern.matcher(stringToEvaluate);
    }

    @Test
    public void getRandomNumberInRangeFromZeroToX() {
        int generatedNumber = getRandomNumberInRange(0,255);
        boolean inRange = (generatedNumber >= 0 && generatedNumber <= 255);
        assertTrue(inRange);
    }

    @Test
    public void getRandomNumberInRangeFromMinToMax() {
        int generatedNumber = getRandomNumberInRange(20,123);
        boolean inRange = (generatedNumber >= 20 && generatedNumber <= 123);
        assertTrue(inRange);
    }

    @Test
    public void generateRandomSizeStringFromStringPossibleCharacters() {
        Range range = new Range(1,10);
        String possibleValues = "abcde";
        String result = RandomGenerator.generateRandomSizeStringFromString(possibleValues,range);
        Matcher matcher = getMatcherFromRegEx("^[" + possibleValues + "]*$", result);
        assertTrue(matcher.find());
    }

    @Test
    public void generateRandomSizeString() {
        Range range = new Range(0,10);
        String result = RandomGenerator.generateRandomSizeString(range);
        Matcher matcher = getMatcherFromRegEx("^.*$", result);
        assertTrue(matcher.find());
    }
}
