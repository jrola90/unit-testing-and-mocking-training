package pl.jrola.trainings.testing.ex2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JrQ- on 2016-01-02.
 */
@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @Before
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Parameters
    public Object[] getPasswordsForTest() {
        return new String[] {"1AS4", "A23", "12312312", "sadasdasdasdas", "1234", "ABdedt"};
    }

    @Parameters
    public Object[] getTooShortPasswordsForTest() {
        return new String[] {"1", "2", "s"};
    }

    @Parameters
    public Object[] getTooLongPasswordsForTest() {
        return new String[] {"12as3456789012345678901", "1asd23456789012345678901123456789012345678901"};
    }

    @Parameters
    public Object[] getPasswordsWithSpacesForTest() {
        return new String[] {"aa a ", " g    vseaa", "123 asd"};
    }

    @Parameters
    public Object[] getEmptyPasswordsForTest() {
        return new String[] {null, " ", "       ", ""};
    }

    @Parameters(method = "getPasswordsForTest")
    @Test
    public void passwordShouldBeValid(String password) {
        assertTrue(passwordValidator.validate(password));
    }

    @Parameters(method = "getTooShortPasswordsForTest")
    @Test
    public void passwordShouldBeAtLeastThreeCharactersLong(String password) {
        catchException(passwordValidator).validate(password);
        assertEquals(IllegalArgumentException.class, caughtException().getClass());
    }

    @Parameters(method = "getTooLongPasswordsForTest")
    @Test
    public void passwordShouldNotBeLongerThat20Characters(String password) {
        catchException(passwordValidator).validate(password);
        assertEquals(IllegalArgumentException.class, caughtException().getClass());
    }

    @Parameters(method = "getPasswordsWithSpacesForTest")
    @Test
    public void passwordShouldNotContainSpace(String password) {
        catchException(passwordValidator).validate(password);
        assertEquals(IllegalArgumentException.class, caughtException().getClass());
    }

    @Parameters(method = "getEmptyPasswordsForTest")
    @Test
    public void passwordShouldNotBeEmpty(String password) {
        catchException(passwordValidator).validate(password);
        assertEquals(IllegalArgumentException.class, caughtException().getClass());
    }
}