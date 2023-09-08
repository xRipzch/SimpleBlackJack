import java.util.Scanner;
import java.util.Random;


public class BlackJack {
    Random rand = new Random();
    int pCard1 = rand.nextInt(10) + 1;
    int pCard2 = rand.nextInt(10) + 1;
    int pTotal = pCard1 + pCard2;
    int dCard1 = rand.nextInt(10) + 1;
    int dCard2 = rand.nextInt(10) + 1;
    int dTotal = dCard1 + dCard2;

    public static void main(String[] args) {
        new BlackJack().run();
    }
 void run() {
        printWelcomeMessage();
        dCards();
        pCards();
        hitOrStay();
        ifHit();
        dNewCards();
        ifHit2();
        ifStay();
        pLooseIfOver21();
        dLooseIfOver21();
        makeDecision();


 }


    void printWelcomeMessage() {
        System.out.println("\nWelcome to BlackJack\n");
    }
    void dCards() {

            System.out.println("Dealer's cards are " + dCard1 + " and " + dCard2);
            System.out.println("Dealer's total is " + dTotal);
        }
    void pCards() {

            System.out.println("Your cards are " + pCard1 + " and " + pCard2);
            System.out.println("Your total is " + pTotal);
        }
    void hitOrStay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to hit or stay?(Type hit or stay)");
        String answer = scanner.nextLine();
        if (answer.equals("hit")) {
            System.out.println("You chose to hit.");
        } else if (answer.equals("stay")) {
            System.out.println("You chose to stay.");
        } else {
            System.out.println("You chose to " + answer + ".");
        }}

    void ifHit() {
        Random rand = new Random();
        int pCard3 = rand.nextInt(10) + 1;
        pTotal = pCard3 + pTotal;
        System.out.println("Your new card is " + pCard3 + " \nMaking your new total " + pTotal);
    }
    void dNewCards(){
        Random rand = new Random();
        int dCard3 = rand.nextInt(10) + 1;
        dTotal = dCard3 + dTotal;
        System.out.println("Dealer's new card is " + dCard3 + " \nMaking the dealer new total " + dTotal);
    }
    void ifHit2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to hit or stay?(Type hit or stay)");
        String answer = scanner.nextLine();
        if (answer.equals("hit")) {
            System.out.println("You chose to hit.");
            ifHit();
            dNewCards();
            ifHit2();
        } else if (answer.equals("stay")) {
            System.out.println("You chose to stay.");
        } else {
            System.out.println("You chose to " + answer + ".");
        }
    }
    void ifStay() {
        if (dTotal < 19) {
            Random rand = new Random();
            int dCard4 = rand.nextInt(10) +1;
            dTotal = dCard4 + dTotal;
            System.out.println("Dealer's new card is " + dCard4 + " \nMaking the dealer new total " + dTotal);
        }
    }
    void dLooseIfOver21(){
    if (dTotal > 21) {
            System.out.println("Dealer busted!");
        System.out.println("You win!");
        }
    }


    void pLooseIfOver21() {
        if (pTotal > 21) {
            System.out.println("You busted!");
            System.out.println("Dealer wins!");
        }
    }



     private void makeDecision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play again?(Type yes or no)");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            System.out.println("You chose to play again.");
            dTotal = 0;
            pTotal = 0;
            run();
        } else if (answer.equals("no")) {
            System.out.println("You chose to quit.");
        } else {
            System.out.println("You chose to " + answer + ".");
        }}
}

