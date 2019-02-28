//hw44#3,4
//The Serpent is a dangerous beast, but its scales give it little defense.
public class Serpent extends Monster {
    public Serpent() {
        attack = 3;
        defense = 15;
    }

    //hw46#1,2
    //Uses the class' custom name
    public String toString() {
        return "Serpent with " + sanitizedHealth() + " health points, " + attack + " attack and " + defense + " defense";
    }
}