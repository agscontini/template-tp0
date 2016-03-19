package ar.fiuba.tdd.template.model;

/**
 * Created by agustin on 18/03/16.
 */
public class Range {

    private int min;

    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
