package gof.structural.decorator;

public class MessageServiceBase implements MessageService {

    private boolean dead = false;
    private int health = 100;
    private int attackPower = 0;

    private double x = 0;
    private double y = 0;
    @Override
    public void attack(MessageService monster) {
        monster.takeDamage(attackPower);
    }

    @Override
    public void move(double x, double y) {
        double dX = x - this.x;
        double dY = y - this.y;

        double dist = Math.hypot(dX, dY);

        this.x += dX / dist;
        this.y += dY / dist;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            dead = true;
        }
    }
}
