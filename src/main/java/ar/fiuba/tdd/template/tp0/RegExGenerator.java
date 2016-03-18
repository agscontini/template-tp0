package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.helpers.NumberRandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    private int maxLength;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    // TODO: Uncomment parameters
    public List<String> generate(String regEx, int numberOfResults) {
        return new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };
    }

    public String generateMultipleCharacters(int amountOfCharacters) {
        String result = "";
        for(int i = 0 ; i < amountOfCharacters ; i++) {
            result += generateAnyCharacter();
        }
        return result;
    }

    private char generateAnyCharacter() {
        int asciiValue = NumberRandomGenerator.getRandomNumber(256);
        return (char) asciiValue;
    }


}