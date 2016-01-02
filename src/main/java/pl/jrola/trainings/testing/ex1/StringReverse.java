package pl.jrola.trainings.testing.ex1;

/**
 * Created by JrQ- on 2015-12-27.
 */
public abstract class StringReverse {
    /**
     * Reverses passed string argument.
     * @param string string to be reversed
     * @return reversed string
     * @throws NullPointerException if passed argument is null or empty
     */
    public static String reverse(String string) throws NullPointerException {

        if (string == null)
            throw new NullPointerException("Cannot reverse null value");

        if ("".equalsIgnoreCase(string.trim()))
            throw new NullPointerException("Cannot reverse empty value");

        int stringSize = string.length();
        StringBuilder builder = new StringBuilder();

        for (int i = stringSize - 1; i >= 0; i--) {
            builder.append(string.charAt(i));
        }

        return builder.toString();
    }
}
