import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Online Shopping System!");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                User.register(username, password);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                if (User.login(username, password)) {
                    System.out.println("Login successful!");
                    boolean isAdmin = username.equals("admin"); // admin panel access

                    while (true) {
                        System.out.println("\n1. View Products\n2. Add Product (Admin)\n3. Logout");
                        int opt = sc.nextInt();
                        sc.nextLine();
                        if (opt == 1) {
                            Product.viewProducts();
                        } else if (opt == 2 && isAdmin) {
                            System.out.print("Product name: ");
                            String name = sc.nextLine();
                            System.out.print("Price: ");
                            double price = sc.nextDouble();
                            System.out.print("Quantity: ");
                            int qty = sc.nextInt();
                            Product.addProduct(name, price, qty);
                        } else if (opt == 3) {
                            break;
                        } else {
                            System.out.println("Invalid or unauthorized option.");
                        }
                    }

                } else {
                    System.out.println("Invalid login!");
                }
            } else {
                System.out.println("Thank you for using the system.");
                break;
            }
        }
        sc.close();
    }
}

