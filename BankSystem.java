import java.util.Scanner;
import java.util.ArrayList;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> accounts = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<Double> balances = new ArrayList<>();

        while(true){
            System.out.println("==== Bank =====");
            System.out.println("1) Open Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) View one account");
            System.out.println("5) View all accounts");
            System.out.println("6) Exit");

            System.out.print("Take your pick: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.print("Enter account name: ");
                String account = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                accounts.add(account);
                passwords.add(password);
                balances.add(0.0);

                System.out.println("Account saved.");

            } else if(choice == 2) {

                if (accounts.size() == 0) {
                    System.out.println("No accounts available.");
                    continue;
                }

                System.out.println("==== Pick the account you would like to deposit in ====");
                for (int i = 0; i < accounts.size(); i++) {
                    System.out.println((i+1) + ") " + accounts.get(i));
                }

                System.out.print("Enter account number: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();

                if (index < 0 || index >= accounts.size()) {
                    System.out.println("Invalid account number.");
                    continue;
                }

                System.out.print("Enter password: ");
                String pass = scanner.nextLine();

                if (!passwords.get(index).equals(pass)) {
                    System.out.println("Incorrect password.");
                    continue;
                }

                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0.");
                } else {
                    balances.set(index, balances.get(index) + amount);
                    System.out.println("Deposit successful. New balance: $" + balances.get(index));
                }

            } else if(choice == 3) {

                if (accounts.size() == 0) {
                    System.out.println("No accounts available.");
                    continue;
                }

                System.out.println("==== Pick the account you would like to withdraw from ====");
                for (int i = 0; i < accounts.size(); i++){
                    System.out.println((i+1) + ") " + accounts.get(i));
                }

                System.out.print("Enter account number: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();

                if (index < 0 || index >= accounts.size()) {
                    System.out.println("Invalid account number.");
                    continue;
                }

                System.out.print("Enter password: ");
                String pass = scanner.nextLine();

                if (!passwords.get(index).equals(pass)) {
                    System.out.println("Incorrect password.");
                    continue;
                }

                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0.");
                } else if (amount > balances.get(index)) {
                    System.out.println("Not enough money in account.");
                } else {
                    balances.set(index, balances.get(index) - amount);
                    System.out.println("Withdraw successful. New balance: $" + balances.get(index));
                }

            } else if(choice == 4) {

                if (accounts.size() == 0) {
                    System.out.println("No accounts available.");
                    continue;
                }

                System.out.print("Enter account name: ");
                String name = scanner.nextLine();

                boolean found = false;

                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).equals(name)) {
                        System.out.println("Account: " + accounts.get(i));
                        System.out.println("Balance: $" + balances.get(i));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Account not found.");
                }

            } else if(choice == 5) {

                if (accounts.size() == 0) {
                    System.out.println("No accounts available.");
                    continue;
                }

                System.out.println("==== All Accounts ====");
                for (int i = 0; i < accounts.size(); i++) {
                    System.out.println(accounts.get(i) + " - $" + balances.get(i));
                }

            } else if(choice == 6) {
                System.out.println("Have a great day!");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
