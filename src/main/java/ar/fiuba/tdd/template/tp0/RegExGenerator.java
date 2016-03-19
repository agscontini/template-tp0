package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.helpers.RandomGenerator;
import ar.fiuba.tdd.template.helpers.RegExParser;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    private int maxLength;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> generate(String regEx, int numberOfResults) {
        List<RegexRule> regexList = RegExParser.parseRegularExpression(regEx);
        List<String> listStrings = new ArrayList<>();
        for (int i = 0; i < numberOfResults - 1 ; i++) {
            listStrings.add(generateMatchingRegexString(regexList));
        }
        return listStrings;
    }

    private String generateMatchingRegexString(List<RegexRule> regexList) {
        StringBuilder result = new StringBuilder();
        for (RegexRule regexRule : regexList) {
            String possibleValue = regexRule.getPossibleValues();
            if (possibleValue.equals(".")) {
                result.append(RandomGenerator.generateRandomSizeString(regexRule.getRange()));
            } else {
                result.append(RandomGenerator.generateRandomSizeStringFromString(regexRule.getPossibleValues(), regexRule.getRange()));
            }
        }
        return result.toString();
    }

}