/**
  Exercise the classes in the Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Protagonist, Monster
 */

// shorthand, used to read from CLI
import java.io.*;
import java.util.*;

/*New feature:
At the end of your game, you will be able to see a list of all the monsters
you've slain on your perilous and brave journey. If you've slain any, that is.*/

//hw3C#0
//UserOfRPG taken from Mr. Brown Mykolyk, Mr. Holmes, Jesse Chan, and Ian Fried
public class UserOfRPG {
    // change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    // each round, a Protagonist and a Monster will be instantiated...
    private Protagonist pat; // Is it man or woman?
    private Monster smaug; // Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;

    //holds all monsters defeated by player
    public ArrayList<Monster> defeatedMonsters;

    //holds the monster that killed the player, or null if it does not exist
    public Monster monsterCauseOfDeath;

    public UserOfRPG() {
        moveCount = 0;
        gameOver = false;
        isr = new InputStreamReader(System.in);
        in = new BufferedReader(isr);
        defeatedMonsters = new ArrayList<Monster>();
        newGame();
    }

    /*
     * ============================================= void newGame() -- gathers info
     * to begin a new game precondition: post: according to user input, modifies
     * instance var for difficulty and instantiates a Protagonist
     * =============================================
     */
    public void newGame() {
        String s;
        String name = "";
        s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

        s += "\nChoose your difficulty: \n";
        s += "\t1: Easy\n";
        s += "\t2: Not so easy\n";
        s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
        s += "Selection: ";
        System.out.print(s);

        try {
            difficulty = Integer.parseInt(in.readLine());
        } catch (IOException e) {
        }

        s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
        System.out.print(s);

        try {
            name = in.readLine();
        } catch (IOException e) {
        }

        System.out.println("Choose your character type!");
        System.out.print("\t2: Magician\nSelection: ");

        int characterType = 1;

        //hw44#6
        //The user can choose between three subclasses.
        try {
            characterType = Integer.parseInt(in.readLine());
        } catch (IOException e) {
        }

        if (characterType == 1) {
            pat = new Magician(name);
        }

        System.out.println("You chose a " + pat);

    }// end newGame()

    /*
     * ============================================= boolean playTurn -- simulates a
     * round of combat pre: Protagonist pat has been initialized
     * 
     * @return the boolean value of "the player survives"
     * =============================================
     */
    public boolean playTurn() {
        //determines if monster will be spawned
        if (Math.random() >= (difficulty / 3.0)) {
            System.out.println("\nNothing to see here. Move along!");
            return true;
        }
            
        else {
            //randomly determines type of spawned monster
            int type = (int)(Math.random() * 3);
            if (type == 0) {
                smaug = new Hydra();
            }
            else if (type == 1) {
                smaug = new Ogre();
            }
            else {
                smaug = new Serpent();
            }
            //hw46#1,2
            System.out.println("\nLo, yonder " + smaug + " approacheth!");
        }

            while (smaug.isAlive() && pat.isAlive()) {
                int d1 = 0;
                int d2 = 0;

                /*
                 * Give the user the option of using a special attack. If you land a hit, you
                 * cause greater damage, ...but if you get hit, you incur more damage.
                 */
                int choice = 1;
                try {
                    System.out.println(System.lineSeparator() + "Do you feel lucky?" + System.lineSeparator()
                            + "    1: Nay" + System.lineSeparator() + "    2: Aye!");
                    choice = Integer.parseInt(in.readLine());
                } catch (IOException e) {
                }

                if (choice == 2)
                    pat.specialize();
                else
                    pat.normalize();

                //hw3E#0
                //attack's parameter type is Character, while the input is the subclass Monster
                d1 = pat.attack(smaug);
                if (smaug.isAlive()) {
                    d2 = smaug.attack(pat);
                } else {
                    //adds to your personal slay list
                    defeatedMonsters.add(smaug);
                }

                System.out.println("\n" + pat.getName() + " dealt " + d1 + " points of damage.");
                if(d2 > 0) {
                    System.out.println("\n" + smaug + " smacked " + pat.getName() + " for " + d2 + " points of damage.");
                }
            } // end while

            if(!pat.isAlive()) {
                monsterCauseOfDeath = smaug;
            }

            // option 1: you & the monster perish
            if (!smaug.isAlive() && !pat.isAlive()) {
                System.out.println("'Twas an epic battle, to be sure... " + "You cut ye olde monster down, but "
                        + "with its dying breath ye olde monster. " + "laid a fatal blow upon thy skull.");
                return false;
            }
            // option 2: you slay the beast
            else if (!smaug.isAlive()) {
                System.out.println("HuzzaaH! Ye olde monster hath been slain!");
                return true;
            }
            // option 3: the beast slays you
            else if (!pat.isAlive()) {
                System.out.println("Ye olde self hath expired. You got dead.");
                return false;
          } // end else

        return true;
    }// end playTurn()

    public static void main(String[] args) {
        // As usual, uncomment progressively in tiny steps

        // loading...
        UserOfRPG game = new UserOfRPG();

        int encounters = 0;

        while (encounters < MAX_ENCOUNTERS && game.playTurn()) {
            encounters++;
            System.out.println();
        }
        //if monsters were defeated, print them all
        if (game.defeatedMonsters.size() > 0) {
            System.out.println("Thou art slain these beasts over thy journey:");
            for (Monster m : game.defeatedMonsters) {
                //hw46#1,2
                System.out.println(" * " + m);
            }
        }
        //otherwise, show disappointment with the player
        else {
            System.out.println("Thou art failed to save the kindom and slay but one monster.");
        }
        //hw46#1,2
        if(game.monsterCauseOfDeath != null)
            System.out.println("The cause of thy death was a " + game.monsterCauseOfDeath + ".");

        System.out.println("Thy game doth be over.");
    }// end main

}// end class UserOfRPG
