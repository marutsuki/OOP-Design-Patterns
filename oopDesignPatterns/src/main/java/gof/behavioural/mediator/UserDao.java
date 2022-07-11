package gof.behavioural.mediator;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class UserDao {
    private static UserDao instance;
    private UserDao() {}
    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    /**
     * Dummy methods mocking database lookups
     */
    public String lookupUsername(long ignored) {
        byte[] randomBytes = new byte[10];
        new Random().nextBytes(randomBytes);
        return new String(randomBytes, StandardCharsets.UTF_8);
    }

    public boolean isBanned(long ignored) {
        return !(Math.random() < 0.5);
    }
}
