package pl.jrola.trainings.testing.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JrQ- on 2016-01-02.
 */
public class NumberExtractor {

    private static final String THREE_DIGIT_IN_A_ROW_PATTERN = "\\d{3}";

    /**
     * Extracts all numbers longer than 3 digits.
     *
     * @param testData string to be parsed
     * @return array of numbers
     */
    public static String[] extract(String testData) {

        List<String> matches = new ArrayList<String>();

        if (testData != null) {

            Pattern pattern = Pattern.compile(THREE_DIGIT_IN_A_ROW_PATTERN);
            Matcher matcher = pattern.matcher(testData);
            while (matcher.find()) {
                matches.add(matcher.group());
            }
        }

        return matches.toArray(new String[]{});
    }
}
