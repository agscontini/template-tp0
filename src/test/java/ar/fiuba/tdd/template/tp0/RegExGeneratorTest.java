package ar.fiuba.tdd.template.tp0;

import org.junit.Test;
import utils.Configuration;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private boolean validate(String regEx, int numberOfResults) {
        Configuration.loadProperties();
        RegExGenerator generator = new RegExGenerator(Configuration.getMaxRandomValue());
        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                    (item1, item2) -> item1 && item2);
    }


    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", 1));
    }

    @Test
    public void testMultipleCharacters() {
        assertTrue(validate("...", 1));
    }

    @Test
    public void testLiteral() {
        assertTrue(validate("\\@", 1));
    }

    @Test
    public void testLiteralDotCharacter() {
        assertTrue(validate("\\@..", 1));
    }

    @Test
    public void testZeroOrOneCharacter() {
        assertTrue(validate("\\@.h?", 1));
    }

    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", 1));
    }

    @Test
    public void testCharacterSetWithQuantifiers() {
        assertTrue(validate("[abc]+", 1));
    }

    @Test
    public void testCharacterSetWithQuestionMarkQuantifier() {
        assertTrue(validate("[abc43yf]?", 1));
    }

    @Test
    public void testCharacterSetWithAsteriskQuantifier() {
        assertTrue(validate("[ab43y]*", 1));
    }

    @Test
    public void testCharacterSetsWithAllQuantifiers() {
        assertTrue(validate("[abc]*[fgh]?[mno]+", 1));
    }

    @Test
    public void testCharacterSetWithQuantifierAndSpecialCharacterBackSlash() {
        assertTrue(validate("[a\\*bc]+", 1));
    }

    @Test
    public void testWholeSetOfRules() {
        assertTrue(validate("as.?m\\[[abc]+m*.*", 1));
    }
}
