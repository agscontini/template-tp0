package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.model.Range;

/**
 * Created by agustin on 18/03/16.
 */
public class RegexRule {

    private String possibleValues;

    private Range range;

    public RegexRule(String possibleValues, Range range) {
        this.possibleValues = possibleValues;
        this.range = range;
    }

    public String getPossibleValues() {
        return possibleValues;
    }

    public Range getRange() {
        return range;
    }
}
