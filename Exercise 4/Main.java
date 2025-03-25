import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void print(String p){

        System.out.print(p);
    }
    public static void println(String p){

        System.out.println(p);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<player> players =new ArrayList<>();

        while (true) {
            print("Enter player's name : ");
            String name = scanner.nextLine();

            print("Enter your actual score: ");
            int score = scanner.nextInt();

            print("Enter your actual level: ");
            int level = scanner.nextInt();
            scanner.nextLine();


            players.add(new player(name, score, level));
            print("You want to add more players? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        while (true) {
            println("""
                    Options:  
                    1) Increase Score  
                    2) Level up   
                    3) Show your player's infos 
                    4) Show All players 
                    5) Exit""");
            println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option < 1 || option > 5) {
                print("Invalid option! Please enter an option (1-5).");
                continue;
            }

            else if  (option == 5) {
                break;
            }

            else if (option == 4) {
                for (player account : players) {
                    account.displayInfo();
                }
                continue;
            }

            print("Enter player name: ");
            String playerName = scanner.nextLine();
            player selectedPlayer = null;

            for (player player : players) {
                if (player.getName().equalsIgnoreCase(playerName)) {
                    selectedPlayer = player;
                    break;
                }
            }

            if (selectedPlayer == null) {
                println("Player not found.");
                continue;
            }

            if (option == 1) {
                print("Enter points to add: ");
                int points = scanner.nextInt();
                scanner.nextLine();
                selectedPlayer.IncreaseScore(points);
            } else if (option == 2) {
                selectedPlayer.LevelUp();
            } else if (option == 3) {
                selectedPlayer.displayInfo();
            } else {
                println("Invalid action.");
            }


            }
        }
    }

