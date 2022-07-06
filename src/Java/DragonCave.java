package Java;

import java.util.Scanner;


public class DragonCave {


    public String DragonCaveCalculation(String message1) {

                String message2 = "";
                String returnMessage = "";
                Scanner obj = new Scanner(System.in);

                System.out.println("You are in a land full of dragons. In front of you,");
                System.out.println();
                System.out.println("you see two caves. In one cave, the dragon is friendly");
                System.out.println();
                System.out.println("and will share the treasure with you. The dragon");
                System.out.println();
                System.out.println("is greedy and hungry and will eat you on sight");
                System.out.println();
                System.out.println("Which cave will you go into? (1 or 2)");
                System.out.println();
                System.out.println();
                System.out.println();

                int input = 0;

                //capturing user input
                try {
                    input = obj.nextInt();
                } catch (Exception e) {

                    System.out.println("You need to input a number");

                }

                if (input == 1) {

                    message1 = "You approach a cave... \n\nIt is dark and spooky..." +
                               "A large dragon jumps out in front of you! He opens his jaws and...\n\n" +
                               "Gobbles you down in one bite!";

                    returnMessage = message1; //testing purposes

                    System.out.println(returnMessage);

                }
                else if (input == 2) {

                    message2 = "You approach the cave.. \n\nit is dark and spooky" +
                                "A large dragon jumps out in front of you!\n\n" +
                                "He is friendly and both of you become great friends and...\n\n" +
                                "Live happily ever after!";

                    returnMessage = message2; //testing purposes

                    System.out.println(returnMessage);

                }

                return returnMessage;
            }

}
