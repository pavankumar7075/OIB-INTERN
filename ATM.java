import java.util.Scanner;

class Acc{
    String accName;
    String accNum;
    String cusId;
    int pin;
    float balance=0.0f;
    int noOfTransactions=0;

    public Acc(String accName, String accNum, String cusId, int pin){
        this.accName=accName;
        this.accNum=accNum;
        this.cusId=cusId;
        this.pin= pin;
        System.out.println("----------------------******----------------------");
        System.out.println("            Account Created Successfully          ");
        System.out.println("----------------------******----------------------");
    }

    public boolean authenticate(){
        boolean isVerified = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Account Number -          ");
        String User = sc.nextLine();
        if ( User.equals(accNum) ) {
            System.out.print("\nEnter Your Pin -                    ");
            int Password = sc.nextInt();
            if ( Password==(pin) ) {
                System.out.println("----------------------*****----------------------");
                System.out.println("                Login successful                 ");
                System.out.println("----------------------*****----------------------");

                isVerified = true;
            }
            else {
                System.out.println("\nXX  Incorrect Password  XX");
            }

        }
        else {
            System.out.println("-!- Username not found -!-\n");

        }
        return isVerified;
    }
    public void deposit() {
        Scanner d =new Scanner(System.in);
        System.out.println(".................// DEPOSIT //................... ");
        System.out.print("Enter the amount to be deposited : ");
        float depo = d.nextFloat();
        if(depo <= 0.0)
        {
            System.out.println("Enter a valid amount\n");
            noOfTransactions++;

        }
        else {
            balance = balance + depo;
            System.out.println();
            System.out.println("     *** Rs. "+depo + " DEPOSITED SUCCESFULLY ***");
            System.out.println("          AVAILABLE BALANCE = "+balance);
            noOfTransactions++;

        }
        System.out.println("..................................................");
    }

    public void withDraw(){
        Scanner w = new Scanner(System.in);
        System.out.println(".................// WITHDRAW //................... ");
        System.out.print("Enter amount to be withdrawn : ");
        float withdraw = w.nextFloat();
        if(withdraw >= balance)
        {
            System.out.println("Low Balance!!!");
        }
        else
        {
            System.out.println("      *** Rs"+withdraw + " WITHDRAWN SUCCESFULLY ***");
            balance = balance - withdraw;
        }
        System.out.println("          AVAILABLE BALANCE Rs. = "+balance);
        System.out.println("..................................................");

    }

    public void balanceEnquiry(){
        System.out.println("............. // ACCOUNT BALANCE //............... \n");
        System.out.println("          AVAILABLE BALANCE = "+balance);
        System.out.println("..................................................");
    }
    public void transactionHistory(){
        System.out.println("........... // TRANSACTION HISTORY // ............");
        System.out.println("     No Of Transactions as of today  = "+balance);
        System.out.println("..................................................");

    }
    public void transfer(){
        System.out.println(".................// TRANSFER //................... ");
        Scanner t = new Scanner(System.in);
        System.out.print("Enter the Account Number :              ");
        String tAccNo= t.nextLine();
        System.out.print("Enter the User Name of the Beneficiary :");
        String tName = t.next();
        System.out.print("Enter the amount to be Transfer :        ");
        float tAmt = t.nextFloat();
        balance -= tAmt;
        noOfTransactions++;
        System.out.println(" //  TRANSFER SUCCESFULL TO ACC NO : "+tAccNo.substring(0,5)+"XXXXX  //");
        System.out.println("          AVAILABLE BALANCE = "+balance);
        System.out.println("................................................... ");

    }

}



public class Atm {
    public static void main(String[] args) {
        System.out.println("**************************************************");
        System.out.println("          Welcome to the BOB Bank!!!\n                 IFSC :BOB001 ");
        boolean operation = false;
        System.out.println("--------------------------------------------------");
        System.out.println("               Enter your choice: \n[1]Banking                               [2]Exit\n");
        System.out.println("--------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == 1) {
            System.out.println("--------------------------------------------------");
            System.out.print("Enter your Account Name:           ");
            String accName = sc.next();
            System.out.println();
            System.out.print("Enter the Account Number:          ");
            String accNum = sc.next();
            System.out.println();
            System.out.print("Enter the Customer Id:             ");
            String cusId = sc.next();
            System.out.println();
            System.out.print("Enter your Pin:                    ");
            int pin = sc.nextInt();
            Acc atm = new Acc(accName, accNum, cusId, pin);
            System.out.println("Do you want to login: Yes/No");
            String want = sc.next();
            if (want.equalsIgnoreCase("Yes")) {
                if (atm.authenticate()) {
                    System.out.println("         Please Select The Banking Options");
                    boolean finished = false;
                    while (!finished) {

                        System.out.println("\n[1] Deposit \n[2] Withdrawl \n[3] Balance Enquiry \n[4] Transactions Done \n[5] Transfer \n[6] Logout");
                        int opt = sc.nextInt();
                        switch (opt) {
                            case 1:
                                atm.deposit();
                                break;
                            case 2:
                                atm.withDraw();
                                break;
                            case 3:
                                atm.balanceEnquiry();
                               break;
                            case 4:
                                atm.transactionHistory();
                                break;
                            case 5:
                                atm.transfer();
                                break;
                            case 6:
                                finished = true;

                                System.out.println("   ***   THANKS YOU!! HAVE A NICE DAY!!!   ***  ");
                                System.exit(0);
                                break;
                            default:
                                System.out.println(" Enter a Valid Option");;
                                break;

                        }
                    }
                }

            } else {
                System.out.println(" *** THANKS YOU!! HAVE A NICE DAY!!! *** \n");
            }

        } else {
            System.out.println(" *** THANKS YOU!! HAVE A NICE DAY *** \n");
        }
    }
}