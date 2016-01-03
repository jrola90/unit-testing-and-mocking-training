package pl.jrola.trainings.testing.ex4;

/**
 * Created by JrQ- on 2016-01-02.
 */
public class User {

    private String password;

    /**
     * Sets password
     *
     * @param passwordMd5 password as md5 hash
     */
    public void setPassword(String passwordMd5) {
        password = passwordMd5;
    }

    /**
     * Gets user's password.
     *
     * @return
     */
    public String getPassword() {
        return password;
    }
}
