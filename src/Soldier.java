/*
*  This is an abstract superclass that demonstrates the use of encapsulation (protected or private attributes )
*  Protected attributes allow subclasses to access and modify these attributes.
*
 * */

public abstract class Soldier {

    //attributes
    protected String playerName;
    protected int healthPoints = 100; // player health start at 100
    protected int armor = 10; //The defensive attribute that reduces incoming damage.
    protected int ammo = 100; // Ammunition count starts at 100
    protected boolean isAlive = true;  //Check if player is alive boolean
    protected int attackPower; // player attack power
    private  int startPos; // player start position

    public  static final int MIN_POSITION = 1;

    public  static final int MAX_POSITION = 10;


    //constructor
     Soldier(String playerName, int startPos, int attackPower){
         this.playerName = playerName;
         this.startPos =  Math.max(MIN_POSITION, Math.min(startPos, MAX_POSITION));
         this.attackPower = attackPower;
    }



    //getter
    public int getPosition() {
        return startPos;
    }

    //setter

    //this method sets up player position and checks that player isn't going out of bounce
    public void setPosition(int newPosition) {
        if (newPosition >= MIN_POSITION && newPosition <= MAX_POSITION) {
            startPos= newPosition;
            System.out.println(playerName + " moves to position " + startPos);
        } else {
            System.out.println("Position out of bounds! Please choose a position between " + MIN_POSITION + " and " + MAX_POSITION + ".");
        }
    }


    // Method


    // Find the target player and shoot at them.
    public abstract void shoot(int target, Soldier[] allPlayers);


    // This function reloads ammo to full capacity
    public abstract void reload();

    //Reduces the character's healthPoints based on the damage received
    public abstract void takeHit(int damage);


    //display status on console
    public void displayStatus() {
        if(isAlive) {
            System.out.println(playerName + " - Position: " + startPos + ", HP: " + healthPoints + ", Armor: " + armor + ", Ammo: " + ammo + ", Attack Power: " + attackPower);
        }
    }

    // check if player is still alive base on hitPoints
    public boolean isAlive() {
        return healthPoints > 0;
    }

}
