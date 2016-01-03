package pl.jrola.trainings.testing.ex4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created by JrQ- on 2016-01-02.
 */
public class UserServiceImplTest {

    private UserDAO userDAO;
    private SecurityService securityService;
    private User user;

    public static final String PASSWORD = "password";
    public static final String MD5_PASSWORD_HASH = "5f4dcc3b5aa765d61d8327deb882cf99";

    @Before
    public void setUp() {
        userDAO = mock(UserDAO.class);
        securityService = mock(SecurityService.class);
        user = mock(User.class);
    }

    @Test
    public void constructorShouldSetFields() {
        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);
        assertSame(userService.getUserDAO(), userDAO);
        assertSame(userService.getSecurityService(), securityService);
    }

    @Test
    public void passwordShouldBeAssigned() {
        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);
        when(user.getPassword()).thenReturn(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(MD5_PASSWORD_HASH);
        doNothing().when(user).setPassword(MD5_PASSWORD_HASH);
        userService.assignPassword(user);
        verify(userDAO).updateUser(user);
    }

}