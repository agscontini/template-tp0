package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.helpers.RandomGenerator;
import ar.fiuba.tdd.template.model.Range;
import ar.fiuba.tdd.template.model.SpecialCharacter;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;


/**
 * Created by agustin on 19/03/16.
 */
public class SpecialCharacterTest {

    @Test
    public void getRangeFromQuestionChar() {
        SpecialCharacter specialCharacter = new SpecialCharacter('?', 15);
        Range range = specialCharacter.getRange();
        Assert.assertEquals(0, range.getMin());
        Assert.assertEquals(1, range.getMax());
    }

    @Test
    public void getRangeFromPlusChar() {
        SpecialCharacter specialCharacter = new SpecialCharacter('+', 15);
        Range range = specialCharacter.getRange();
        Assert.assertEquals(1, range.getMin());
        Assert.assertEquals(15, range.getMax());
    }

    @Test
    public void getRangeFromAsteriskChar() {
        SpecialCharacter specialCharacter = new SpecialCharacter('*', 15);
        Range range = specialCharacter.getRange();
        Assert.assertEquals(0, range.getMin());
        Assert.assertEquals(15, range.getMax());
    }

    @Test
    public void getRangeFromSquareBracketChar() {
        SpecialCharacter specialCharacter = new SpecialCharacter(']', 15);
        Range range = specialCharacter.getRange();
        Assert.assertEquals(1, range.getMin());
        Assert.assertEquals(1, range.getMax());
    }

    @Test
    public void getRangeFromIncorrectSpecialCharacter() {
        SpecialCharacter specialCharacter = new SpecialCharacter('[', 15);
        Assert.assertNull(specialCharacter.getRange());
    }

}
