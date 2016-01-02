package pl.jrola.trainings.testing.ex3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by JrQ- on 2016-01-02.
 */
@RunWith(JUnitParamsRunner.class)
public class ExtractNumbersTest {

    private static final String[] EMPTY_ARRAY = {};

    @Parameters
    public Object[] getTestingData() {
        return $($(EMPTY_ARRAY, null), $(EMPTY_ARRAY, "abc 12"), $(new String[]{"345"}, "asddsa 345 12bb23"), $(new String[]{"345", "123"}, "asddsa 345 123bb23"));
    }

    @Test
    @Parameters(method = "getTestingData")
    public void methodShouldExtractAllThreeDigitLongStrings(String[] expecteds, String testData) {
        assertArrayEquals(expecteds, NumberExtractor.extract(testData));
    }

}
