import java.util.*;
class Game
{
    public void startGame()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        System.out.println("......................................................");

        System.out.println("                ***   RULES   ***                     ");
        System.out.println("[*] A RANDOM NUMBER WILL BE GENERATED\n[*] U WILL HAVE TO GUESS THE RANDOM NUMBER\n[*] NO OF CHANCES TO GUESS THE NUMBER IS 5\n[*] U WILL BE REWARDED FOR THE CURRECT GUESS");
        System.out.println("------------------START THE GAME----------------------");

        System.out.println("       |||     Random Number Generated      |||       ");
        int noOfGuess = (int)(Math.ceil(Math.log(100)));
        int y=noOfGuess;

        int rewardPoints = 100; //Used for correct guess
        int i = 0;
        for( i = 0; i < noOfGuess; i++)
        {
            System.out.println("                  -----------------");
            System.out.println("                  NO OF GUESSES : "+y+"");
            System.out.println("                  -----------------");

            y--;
            Scanner sc = new Scanner(System.in);
            System.out.print("       Enter The Number You Have Guessed : ");
            int k = sc.nextInt();
            if(k == randomNum)
            {
                System.out.println("....................................................");
                System.out.println("            GOT IT! WON THE GAME !!!\n");
                System.out.println("            Your Reward points :" + rewardPoints);
                System.out.println("....................................................");

                break;
            }
            else if(k > randomNum)
            {
                if(k - randomNum > 25)
                {
                    System.out.println("[x]    Far Away Leaving Behind1!!!");
                }
                else
                {
                    System.out.println("[x]    Nearly Far!!!");
                }
            }
            else
            {
                if(randomNum - k > 25)
                {
                    System.out.println("[x]    U Are Far Behind !!!");
                }
                else
                {
                    System.out.println("[x]    U Are Nearing Ahead!!!");
                }
            }
            rewardPoints = rewardPoints - 10; //decreasing rewardPoints for every wrong guess
        }
        if(i == noOfGuess)
        {
            System.out.println(".....................................................");
            System.out.println("                    GAME OVER !!!");
            System.out.println("The Random number : " + randomNum);
            rewardPoints = 0;
            System.out.println("Reward Points : " + rewardPoints);
            System.out.println(".....................................................");

        }
    }
}
public class GuessingNumber {
    public static void main(String args[])
    {
        System.out.println(".....................*********........................");
        System.out.println("               NUMBER GUESSING GAME !!!");
        System.out.println(".....................*********........................");

        System.out.println("              Select your choice\n       [1] Play                [2] Exit \n");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 1)
        {
            Game g = new Game();
            g.startGame();
            System.out.println("Do you want to play again: Yes/No\n");
            String a = sc.next();
            while(a.equalsIgnoreCase("Yes"))
            {
                g.startGame();
                System.out.println("Do you want to play once again: Yes/No\n");
                a = sc.next();
            }
        }
        else {
            System.out.println("You are now exited!!!\n");
        }


    }
}