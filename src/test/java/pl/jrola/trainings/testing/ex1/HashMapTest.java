package pl.jrola.trainings.testing.ex1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by JrQ- on 2015-12-27.
 */
@RunWith(JUnitParamsRunner.class)
public class HashMapTest {

    private HashMap<String, String> testedMap;
    private static final Object[] GET_METHOD_TESTED_VALUES = $($("key1", "value1"), $("key2", "value2"), $("key3", "value3"));
    private static final String KEY = "KEY";
    private static final Object[] DUPLICATE_KEY_TESTED_VALUES = $($("value1_old", "value1_new"), $("value2_old", "value2_new"), $("value3_old", "value3_new"));
    private static final Object[] NULL_KEY_TESTED_VALUES = $("val1", "val2", "val3");

    @Before
    public void init() {
        testedMap = new HashMap<String, String>();
        for (Object item : GET_METHOD_TESTED_VALUES) {
            Object[] i = (Object[]) item;
            testedMap.put((String) i[0], (String) i[1]);
        }
    }

    @Parameters
    public Object[] getMapEntries() {
        return GET_METHOD_TESTED_VALUES;
    }

    @Parameters
    public Object[] getMapValues() {
        return DUPLICATE_KEY_TESTED_VALUES;
    }

    @Parameters
    public Object[] getMapValuesForNullTest() {
        return NULL_KEY_TESTED_VALUES;
    }

    @Parameters(method = "getMapEntries")
    @Test
    public void getMethodShouldReturnAddedValue(String key, String value) {
        assertEquals(value, testedMap.get(key));
    }

    @Parameters(method = "getMapValues")
    @Test
    public void addingTheSameKeyShouldReplaceOldOne(String oldValue, String newValue) {
        testedMap.put(KEY, oldValue);
        testedMap.put(KEY, newValue);

        assertEquals(newValue, testedMap.get(KEY));
    }

    @Test
    public void clearMethodShouldRemoveAllItems() {
        testedMap.clear();
        assertEquals(0, testedMap.size());
    }

    @Parameters(method = "getMapValuesForNullTest")
    @Test
    public void nullValueShouldBeValidKey(String value) {
        testedMap.put(null, value);
        assertEquals(null, testedMap.get(value));
    }

}