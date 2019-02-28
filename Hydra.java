//hw44#3,4
//The Hydra seems tame at first, but the longer it is atatcked, the more damage it inflicts.
//It also heals slightly after every attack.
class Hydra extends Monster {
    public Hydra() {
        health = 80;
    }

    //hw46#moreThinking
    //this overriden method partially heals the hydra and increases its attack on every turn,
    //mimicking the regenerative properties of the hydra of lore.
    public int attack(Character target) {
        health += health / 4;
        attack *= 1.8;

        //hw44#3,4
        return super.attack(target);
    }

    //hw46#1,2
    //Uses the class' custom name
    public String toString() {
        return "Hydra with " + sanitizedHealth() + " health points, " + attack + " attack and " + defense + " defense";
    }
}