package pl.jrola.trainings.testing.ex1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by JrQ- on 2015-12-27.
 */
@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {

    @Parameters
    public Object[] getStringsToTest() {
        return $($("test", "tset"), $("jareK", "Keraj"), $("5432", "2345"));
//        return new String[][]{{"test", "tset"}, {"jareK", "Keraj"}, {"5432", "2345"}};
    }

    @Parameters
    public Object[] getValuesForExceptions() {
        return $($(""), (null));
//        return new String[]{"", null};
    }

    @Test
    @Parameters(method = "getStringsToTest")
    public void functionShouldGiveReversedString(String testedString, String expectedResult) {
        assertEquals(expectedResult, StringReverse.reverse(testedString));
    }

    @Test(expected = NullPointerException.class)
    @Parameters(method = "getValuesForExceptions")
    public void functionShouldThrowExceptionWhenParameterIsNullOrEmpty(String testedValue) {
        StringReverse.reverse(testedValue);
    }

}