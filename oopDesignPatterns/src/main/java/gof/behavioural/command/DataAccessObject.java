package gof.behavioural.command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DataAccessObject {
    private static DataAccessObject instance;
    private DataAccessObject() {}

    public static DataAccessObject getInstance() {
        if (instance == null) {
            instance = new DataAccessObject();
        }
        return instance;
    }

    public void saveToDatabase(String key, String value) {
        log.info("Saving to database {}: {}", key, value);
    }
}
