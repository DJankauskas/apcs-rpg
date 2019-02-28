public class Monster extends Character {
    public Monster() {
        strength = (int) (Math.random() * 45) + 20;
        health = 150;
        attack = 1;
        defense = 20;
    }

    public String toString() {
        return "monster " + " with " + health + " health points.";
    }
}