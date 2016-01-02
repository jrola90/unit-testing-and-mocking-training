package pl.jrola.trainings.testing.ex1;

/**
 * Created by JrQ- on 2016-01-02.
 */
public class PasswordValidator {

    /**
     * Validates password against below rules:
     * - password must be between 3 and 20 characters long,
     * - password cannot be empty,
     * - password cannot contain space(s).
     * @param password password to be validated
     * @return true if password is correct, otherwise false
     * @throws IllegalArgumentException if above rules are not met
     */
    public boolean validate(String password) {

        boolean ret = Boolean.FALSE;

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password cannot contain space");
        }

        int passwordLength = password.length();
        if (passwordLength < 3 || passwordLength > 20) {
            throw new IllegalArgumentException("Password cannot be shorter than 3 characters and longer than 20 characters");
        }

        ret = Boolean.TRUE;

        return ret;
    }
}