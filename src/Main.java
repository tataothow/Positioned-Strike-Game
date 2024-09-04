import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Creates an array of Sniper objects with a maximum capacity of 2 players.
        Sniper[] players = new Sniper[2];
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter details for Soldier " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Starting Position (1 to 10): ");
            int pos = Math.max(1, Math.min(input.nextInt(), 10));
            int attackPower = 5 + random.nextInt(26);  // generate Random attack power between 5 and 30
            players[i] = new Sniper(name, pos, attackPower);
            input.nextLine(); // Consume newline
        }

        Game rounds = new Game();
        // Game loop
        while (rounds.aliveCount(players) > 1) {
            for (Soldier currentSoldier : players) {
                if (currentSoldier.isAlive()) {
                    // Method to handle a player's turn
                    rounds.takeTurn(currentSoldier, players, input);
                }
            }
        }

        // Game Over message
        rounds.gameOver(players);

        input.close();
    }



}
