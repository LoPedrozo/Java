import java.util.Scanner;
public class Main{
    public static void println(String a){

        System.out.println(a);
    }

    public static void print(String a){

        System.out.print(a);
    }
    public static void main(String[] args) {
        agenda myagenda = new agenda();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            println("--------------------------");
            println("""
                    Menu: 
                    1-Add contact
                    2-Search a contact
                    3-Delete a contact
                    4-Show all contacts 
                    5-Exit
                    """);
            print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    while (true) {
                        print("Enter the contact's name: ");
                        String name = scanner.nextLine();
                       print("Enter the phone number: ");
                        String number = scanner.nextLine();
                        myagenda.addContact(name, number);
                       print("You want to add more contacts? (yes/no): ");
                        String response = scanner.nextLine().toLowerCase();

                        if (response.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    myagenda.searchContact(searchName);
                    break;
                case 3:
                    println("<<Enter Contact to delete");
                    print( "Contact's name: ");
                    String deleteName = scanner.nextLine();
                    print("Contact's number: ");
                    String deleteNumber = scanner.nextLine();
                    myagenda.removeContact(deleteName,deleteNumber);
                    break;
                case 4:
                    myagenda.showContacts();
                    break;
                case 5:
                    println("EXITING...");
                    scanner.close();
                    return;
                default :
                    print("Invalid option . Please try again");
                    break;
            }

        }
    }
}
