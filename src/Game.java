import java.util.Scanner;
/*
 This class manages the game by handling game rounds, determining game over conditions,
 and tracking players who are still alive.
 */
public class Game {

    //empty constructor
    Game(){}

    //Handles a player's turn, using a switch statement to determine the action to perform.
    public static void takeTurn(Soldier currentSoldier, Soldier[] allSoldiers, Scanner input) {
        System.out.println("\n--- " + currentSoldier.playerName + "'s Turn ---");
        System.out.println("Pick an action: 1. Set Position 2. Shoot 3. Reload");


        //check to make sure player input is valid number
        if( !input.hasNextInt() ){
            System.out.println("Player enter an invalid number");
        }

        int userPick = input.nextInt();
        int targetPosition;

        // Uses a switch statement to select an action, such as setting position, shooting, or reloading ammo.
        switch (userPick){
            case 1:
                System.out.print("Enter new position (1 to 10): ");
                targetPosition =  Math.max(1, Math.min(input.nextInt(), 10));
                currentSoldier.setPosition(targetPosition);
                break;
            case 2:
                System.out.println("Enter new target position (1 to 10):");
                targetPosition =  Math.max(1, Math.min(input.nextInt(), 10));
                currentSoldier.shoot(targetPosition, allSoldiers);
                break;
            case 3:
                System.out.println("Ammunition reload");
                currentSoldier.reload();
                break;
            default:
                System.out.println("Invalid Pick");
                break;
        }

        // Display status of all players, by calling the display method from superclass soldier
        for (Soldier soldier : allSoldiers) {
            soldier.displayStatus();
        }

    }

    // Helper method to count the number of alive soldiers
    public static int aliveCount(Soldier[] soldiers) {
        int count = 0;
        for (Soldier soldier : soldiers) {
            if (soldier.isAlive()) {
                count++;
            }
        }
        return count;
    }


    // Checks if the game is over by verifying if only one player is still alive.
    public static void gameOver(Sniper[] player){

        for(Soldier soldier: player ){
            if (!soldier.isAlive()) {
                System.out.println(soldier.playerName + " has been defeated!");
            }
        }
        System.out.println("Game Over!");
    }



}
