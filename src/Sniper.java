/*
* This subclass extends the parent class Soldier and inherits its attributes and methods.
* */
public class Sniper extends Soldier {

    private boolean hit;

    //constructor
    Sniper(String playerName, int strtPosition, int attackPower){
        super(playerName,strtPosition,attackPower); // super used to reference the parent class

    }

    // shoot find target and shoot at target player
    @Override
    public void shoot(int targetPosition, Soldier[] allPlayers) {
        if (ammo > 0) {
            System.out.println(playerName + " aims at position " + targetPosition + "!");
            hit = false;
            for (Soldier player : allPlayers) {
                if (player.getPosition() == targetPosition && player != this && player.isAlive()) {
                    player.takeHit(attackPower-player.armor); // attack power minus the armor to reduce the damage
                    hit = true;
                }
            }
            if (!hit) {
                System.out.println(playerName + " missed! No player at position " + targetPosition + ".");
            }
            ammo -= attackPower;
        } else {
            System.out.println(playerName + " is out of ammo! Reload");
        }
    }



    // reload to full capacity which is 100
    @Override
    public void reload() {
        System.out.println("reloads.");
        ammo = 100;
    }


    @Override
    public void takeHit(int damage) {
        int effectiveDamage = damage;
        healthPoints -= effectiveDamage;
        System.out.println(playerName + " took " + effectiveDamage + " damage. Remaining HP: " + healthPoints);
        if (healthPoints <= 0) {
            isAlive = false;
            System.out.println(playerName + " has been defeated!");
        }
    }



}
