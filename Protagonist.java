//unchanged header error: Protagonist is not abstract and does not override abstract method specialize() in Protagonist
//instantiate Protaginist error: Protagonist is abstract; cannot be instantiated
public abstract class Protagonist extends Character {
    private String name;
    private final double BASE_ATK;
    private final int BASE_DEF;

    public Protagonist(String name) {
        this.name = name;
        strength = 35;
        health = 150;
        attack = BASE_ATK = 1;
        defense = BASE_DEF = 20;
    }

    //hw3C#1
    public String getName() {
        return name;
    }

    //hw3C#1
    public abstract void specialize();

    //hw3C#1
    public void normalize() {
        attack = BASE_ATK;
        defense = BASE_DEF;
    }
    
    public String toString() {
        return "protagonist " + name + " with " + sanitizedHealth() + " health points";
    }

}