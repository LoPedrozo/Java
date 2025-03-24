import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void println(String pl) {

        System.out.println(pl);
    }
    public static void print(String p) {

        System.out.print(p);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            print("Enter book title (or 'exit' to stop): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("exit")) {
                break;
            }

            print("Enter author: ");
            String author = scanner.nextLine();

            print("Enter publication year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            books.add(new Book(title, author, year));
        }


        println("\nLibrary Collection:");
        for (Book book : books) {
            book.displayInfo();
        }

        scanner.close();
    }
}