package pl.jrola.trainings.testing.ex4;

/**
 * Created by JrQ- on 2016-01-02.
 */
public class UserServiceImpl {

    private UserDAO userDAO;
    private SecurityService securityService;

    /**
     * Assigns password to given user.
     *
     * @param user user
     */
    public void assignPassword(User user) {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    /**
     * Constructor.
     *
     * @param userDAO         UserDAO object
     * @param securityService SecurityService object
     */
    public UserServiceImpl(UserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    /**
     * Gets DAO object.
     *
     * @return DAO object
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Gets SecurityService object.
     *
     * @return SecurityService object
     */
    public SecurityService getSecurityService() {
        return securityService;
    }
}