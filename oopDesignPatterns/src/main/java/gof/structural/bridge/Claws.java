package gof.structural.bridge;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Claws implements Weapon {

    @Override
    public void attack(Entity e) {
        log.info("{} is attacked with claws!", e);
    }
}
