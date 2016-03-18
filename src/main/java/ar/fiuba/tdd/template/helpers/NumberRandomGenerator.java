package ar.fiuba.tdd.template.helpers;

import java.util.Random;

/**
 * Created by agustin on 18/03/16.
 */
public class NumberRandomGenerator {

    public static int getRandomNumber(int amountOfPossibleValues) {
        Random random = new Random();
        int randomValue = random.nextInt(amountOfPossibleValues);
    }
}
