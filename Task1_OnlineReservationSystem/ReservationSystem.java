import java.util.*;
class User {
    String username;
    String password;

    User(String u, String p) {
        username = u;
        password = p;
    }
}
class Ticket {
    int pnr;
    String name;
    String train;
    String from;
    String to;
    String date;

    Ticket(int pnr, String name, String train, String from, String to, String date) {
        this.pnr = pnr;
        this.name = name;
        this.train = train;
        this.from = from;
        this.to = to;
        this.date = date;
    }
    void display() {
        System.out.println("PNR: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Train: " + train);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Date: " + date);
    }
}

public class ReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static User user = new User("admin", "1234");

    public static void main(String[] args) {

        if (!login()) {
            System.out.println("Invalid Login!");
            return;
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reserve();
                    break;
                case 2:
                    cancel();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static boolean login() {
        System.out.print("Enter Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        return u.equals(user.username) && p.equals(user.password);
    }

    static void reserve() {
        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Train Name: ");
        String train = sc.next();

        System.out.print("From: ");
        String from = sc.next();

        System.out.print("To: ");
        String to = sc.next();

        System.out.print("Date: ");
        String date = sc.next();

        int pnr = new Random().nextInt(10000);

        Ticket t = new Ticket(pnr, name, train, from, to, date);
        tickets.add(t);

        System.out.println("Ticket Reserved Successfully!");
        System.out.println("Your PNR: " + pnr);
    }

    static void cancel() {
        System.out.print("Enter PNR: ");
        int pnr = sc.nextInt();

        for (Ticket t : tickets) {
            if (t.pnr == pnr) {
                t.display();
                System.out.print("Confirm cancel? (yes/no): ");
                String confirm = sc.next();

                if (confirm.equalsIgnoreCase("yes")) {
                    tickets.remove(t);
                    System.out.println("Ticket Cancelled!");
                }
                return;
            }
        }

        System.out.println("PNR not found!");
    }
}
