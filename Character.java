public class Character {

    // modified fields from public to protected
    protected int health;
    protected int strength;
    protected double attack;
    // public double attackNormal;
    protected int defense;
    // public int defenseNormal;

    //hw3C#1
    public boolean isAlive() {
        return health > 0;
    }

    //hw3C#1
    public int getDefense() {
        return defense;
    }

    //hw3C#1
    public void lowerHP(int dmg) {
        health -= dmg;
    }

    //hw3E#0
    //hw3C#1
    public int attack(Character target) {
        int damage = (int) ((strength * attack) - target.getDefense());
        target.lowerHP(damage);
        return damage;
    }

    //caps health displayed to user at 0
    protected int sanitizedHealth() {
        return health > 0 ? health : 0;
    }
}