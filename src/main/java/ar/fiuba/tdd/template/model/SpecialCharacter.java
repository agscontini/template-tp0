package ar.fiuba.tdd.template.model;

import utils.Configuration;

/**
 * Created by agustin on 18/03/16.
 */
public class SpecialCharacter {

    private char specialCharacter;

    public SpecialCharacter(char specialCharacter) {
        this.specialCharacter = specialCharacter;
    }

    public Range getRange() {
        switch (specialCharacter) {
            case '?':
                return new Range(0,1);
            case '+':
                return new Range(1, Configuration.maxRandomValue);
            case '*':
                return new Range(0,Configuration.maxRandomValue);
            case ']':
                return new Range(1,1);
            default:
                return null;
        }
    }
}
