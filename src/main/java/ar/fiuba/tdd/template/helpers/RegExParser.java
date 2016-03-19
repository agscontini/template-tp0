package ar.fiuba.tdd.template.helpers;

import ar.fiuba.tdd.template.model.Range;
import ar.fiuba.tdd.template.model.SpecialCharacter;
import ar.fiuba.tdd.template.tp0.RegexRule;
import utils.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agustin on 18/03/16.
 */
public class RegExParser {

    public static List<RegexRule> parseRegularExpression(String regEx) {
        ArrayList<RegexRule> result = new ArrayList<>();
        for (int i = regEx.length() - 1 ; i >= 0 ; i--) {
            RegexRule regexRule;
            char character = regEx.charAt(i);
            if (i > 0 && isSpecialCharacter(character)) {
                if (isBackSlash(regEx.charAt(i - 1))) {
                    regexRule = new RegexRule(String.valueOf(character), new Range(1, 1));
                } else {
                    String strBeforeSpecialChar = regEx.substring(0, i - 1);
                    String possibleValues = getSetOfPossibleValues(strBeforeSpecialChar);
                    i -= getDecreasingSize(possibleValues);
                    SpecialCharacter specialCharacter = new SpecialCharacter(character);
                    String values = removeBackSlashes(possibleValues);
                    regexRule = new RegexRule(values, specialCharacter.getRange());
                }
            } else {
                regexRule = new RegexRule(String.valueOf(character), new Range(1,1));
            }
            result.add(regexRule);
        }
        return result;
    }

    private static String removeBackSlashes(String possibleValues) {
        return possibleValues.replace("\\","");
    }

    private static int getDecreasingSize(String possibleValues) {
        int possibleValuesLength = possibleValues.length();
        if ( possibleValuesLength > 1 ) {
            return possibleValuesLength + 2;
        } else {
            return 1;
        }
    }

    private static String getSetOfPossibleValues(String strBeforeSpecialChar) {
        int lastPosition = strBeforeSpecialChar.length() - 1;
        char lastChar = strBeforeSpecialChar.charAt(lastPosition);
        if (isClosingSetOfValues(lastChar)) {
            return strBeforeSpecialChar.substring(getLastOpeningSetOfValuesPosition(strBeforeSpecialChar) + 1, lastPosition - 1);
        } else {
            return String.valueOf(lastChar);
        }

    }

    private static int getLastOpeningSetOfValuesPosition(String strBeforeSpecialChar) {
        int position = strBeforeSpecialChar.lastIndexOf('[');
        if (position > 0 && isBackSlash(strBeforeSpecialChar.charAt(position - 1))) {
            return getLastOpeningSetOfValuesPosition(strBeforeSpecialChar.substring(0, position - 1));
        } else {
            return position;
        }
    }

    private static boolean isSpecialCharacter(char character) {
        return Configuration.specialCharacters.contains(String.valueOf(character));
    }

    private static boolean isBackSlash(char character) {
        return character == '\\';
    }

    private static boolean isClosingSetOfValues(char character) {
        return character == ']';
    }
}