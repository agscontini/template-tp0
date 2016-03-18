package ar.fiuba.tdd.template.tp0;

import utils.Configuration;

import java.util.List;

/**
 * Created by agustin on 18/03/16.
 */
public class Main {

    public static void main(String [ ] args) {

        Configuration.loadProperties();

        String regExpression = args[0];
        String tempAmountRegExpression = args[1];
        int amountRegExpression = Integer.parseInt(tempAmountRegExpression);
        RegExGenerator regExGenerator = new RegExGenerator(Configuration.maxStringRegexGenerator);
        List<String> resultStringsFromRegex = regExGenerator.generate(regExpression, amountRegExpression);
        printResults(resultStringsFromRegex);

    }

    private static void printResults(List<String> resultStringsFromRegex) {
        for (String element : resultStringsFromRegex) {
            System.out.println("String: " + element);
        }
    }
}
