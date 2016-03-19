package ar.fiuba.tdd.template.model;

/**
 * Created by agustin on 18/03/16.
 */
public class SpecialCharacter {

    private char specialCharacter;

    private int maxRandomValue;

    public SpecialCharacter(char specialCharacter, int maxRandomValue) {
        this.specialCharacter = specialCharacter;
        this.maxRandomValue = maxRandomValue;
    }

    public Range getRange() {
        switch (specialCharacter) {
            case '?':
                return new Range(0,1);
            case '+':
                return new Range(1, maxRandomValue);
            case '*':
                return new Range(0, maxRandomValue);
            case ']':
                return new Range(1,1);
            default:
                return null;
        }
    }
}
