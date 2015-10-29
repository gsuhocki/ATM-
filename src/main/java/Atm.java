import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by gsuhocki on 9/30/15.
 * Begin by creating Atm class and located within, classes Account and Transaction.
 */
public class Atm {

    private Account account1;
    private Transaction transaction1;

    /*The Atm will generate a new account and a new transaction.  The new account and transaction will contain
     *getters and setters.  In addition, the Atm class will contain a print receipt method for transactions processed.
     */


    public Atm() {
        account1 = new Account(12345, 500);
        transaction1 = new Transaction();
    }


        public Account getAccount1() {
            return account1;
        }

        public void setAccount1(Account account1) {
            this.account1 = account1;
        }

        public Transaction getTransaction1() {
            return transaction1;
        }

        public void setTransaction1(Transaction transaction1) {
            this.transaction1 = transaction1;
        }

        public void printReceipt() {
            System.out.println(transaction1.toString());
        }

        /*The withdrawl method will begin by stating the balance.  After which the withdrawl amount will be subtracted
         *from the initial balance and the remaining balance will be stated.
         */

        public void withDrawl(int amount) {
            int balance = account1.getBalance();
            balance = balance - amount;
            account1.setBalance(balance);

            transaction1.setTransaction("Withdrawl of " + amount + "\n" + "Your balance is " + balance);
            this.printReceipt();
        }

        public void showBalance() {
            account1.setBalance(account1.balance);
            account1.getBalance();
        }

    /*
    Create constructor for the ATM using account number and account balance
     */

    public class Account {
        private int accountNumber;
        private int balance;


        public Account(int accountNumber, int balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        /*Within the account class, getters and setters are set to retrieve account number and balance.
         */

        public int getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    /*Create a class transaction and within the class, create an ArrayList called record.  Record will contain a
     *a getter and setTransaction method adding individual items to the ArrayList.
     */

    public class Transaction {
       private ArrayList<String> record = new ArrayList<String>();

    /* Convert each item in the arraylist to a toString.
     */
        @Override
        public String toString (){
            String output="";
            System.out.println(record.get(record.size()-1));
            return output;
        }


        public ArrayList<String> getRecord() {
            return record;
        }

        public void setTransaction(String transin) {
            record.add(transin);
        }
    }

    public static void main(String[] args) {
        Atm atm = new Atm();

        /*Within the console, the first line begins by stating the available balance in the account.
         *Next, the console accepts the user input amount to withdrawl.  A check is entered to ensure the user entered
         * the correct withdrawl amount.  The withdrawl amount is subtracted from the original balance and the
         * remaining balance is printed.
         */
        Scanner user = new Scanner(System.in);
        String amt;
        int newBalance;
        String decision;
        String nextTransaction;
        boolean YES;
        boolean yesTransaction=true;

        //Run while loop if user requests another transaction

        while (yesTransaction = true) {
            System.out.println("Your balance is " + atm.account1.getBalance());
            System.out.println("Please enter the amount you would like to withdrawl... ");
            amt = user.nextLine();
            int newAmt = Integer.parseInt(amt);
            newBalance = atm.account1.getBalance() - newAmt;

            //Set balance to current balance if transaction > 1
            atm.account1.setBalance(newBalance);
            System.out.println("You have entered $" + amt + ". Is this correct?");
            decision = user.nextLine();
            if (decision.equals("yes")) {
                System.out.println("Withdrawl of " + (amt) + ". Your balance is " + newBalance);
            } else {
                System.out.println("Please enter correct amount");

            }
            System.out.println("Would you like to make another transaction?");
            nextTransaction = user.nextLine();
            if (nextTransaction.equals("yes")) {
                yesTransaction = true;
            } else {
                yesTransaction = false;
                System.out.println("Thank you for your business.");
            }

        }
    }
}





