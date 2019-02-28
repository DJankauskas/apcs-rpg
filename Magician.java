//Magician uses powerful spells to inflict more damage, but has less defense.
//Error without overriding:
//Magician is not abstract and does not override abstract method specialize() in Protagonist
public class Magician extends Level {
    private final double BASE_ATK = 1.2;
    private final int BASE_DEF = 15;

    public Magician(String name) {
        //hw44#3
        //initializes name field along with attack and defense attributes
        super(name);
        normalize();
        health = 100;
    }

    public void normalize() {
        attack = BASE_ATK;
        defense = BASE_DEF;
    }

    public void specialize() {
        attack *= 2.5;
        defense /= 3;
    }

    //hw46#1,2
    //Uses the class' custom name
    public String toString() {
        return "Magician " + getName() + " with " + health + " health points";
    }
} 