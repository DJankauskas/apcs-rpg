//hw44#3,4
//The Ogre is slow to attack, but is difficult to kill.
public class Ogre extends Monster {
    public Ogre() {
        attack = 0.8;
        defense = 40;
        health = 250;
    }

    //hw46#1,2
    //Uses the class' custom name
    public String toString() {
        return "Ogre with " + sanitizedHealth() + " health points, " + attack + " attack and " + defense + " defense";
    }
}