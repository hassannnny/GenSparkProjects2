package Java;

import java.util.Scanner;


public class GuessTheNumber {

    public static void main(String[] args) {

        String again = " y";
        String name = "";
        boolean yes = true;


        //just a test for git


        Scanner obj = new Scanner(System.in);

        int guess = 21;
        int num = 0;
        int count = 1;
        name = UserName();

        while (yes) {

            num = (int) ((Math.random() * 20) + 1);

            System.out.println();
            System.out.println();
            
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            System.out.println("Take a guess");
            System.out.println();

            guess = UserGuess();

            while (guess != num) {

                if (guess > num) {
                    System.out.println();
                    System.out.println("Your guess is too high.");
                    System.out.println();
                    System.out.println("Take a guess.");
                    System.out.println();
                    count++;
                } else if (guess < num) {
                    System.out.println();
                    System.out.println("Your guess is too low.");
                    System.out.println();
                    System.out.println("Take a guess.");
                    System.out.println();
                    count++;
                }

                guess = UserGuess();
            }

            System.out.println();
            System.out.println("Good job, " + name + "! You guessed my number in " + count + " guesses!"); 
            System.out.println();
            System.out.println("Would you like to play again? (y or n)");
            System.out.println();
            System.out.println();

            try {

                again += obj.next().charAt(0);

            }catch (Exception e) {

                System.out.println("Please enter 'y' or 'n'");

            }


            if (again.contains("n")) {
                yes = false;
            }

            guess = 21;
            count = 1;
        }
    }

    public static String UserName() {

        Scanner obj = new Scanner(System.in);

        System.out.println("Hello! What is your name?");
        System.out.println();
        System.out.println();

        //capturing user input
        String name = obj.nextLine();

        System.out.println();

        return name;
    }

    public static int UserGuess() {

        Scanner obj = new Scanner(System.in);

        int guess = 0;

        try {

            guess = obj.nextInt();

        } catch (Exception e) {
            System.out.println("Please enter an integer");
        }

        return guess;
    }
}


















































               // while (guess != num && again.equals("y")) {

              
                // guess = obj.nextInt();
// 
//                
//                 // if (guess > num) {
//                    System.out.println();
//                    System.out.println("Your guess is too high.");
//                    System.out.println();
//                    System.out.println("Take a guess.");
//                    System.out.println();
//                    count++;
//                } else if (guess < num) {
//                    System.out.println();
//                    System.out.println("Your guess is too low.");
//                    System.out.println();
//                    System.out.println("Take a guess.");
//                    System.out.println();
//                    count++;
//                }
               
               
              //  if (guess == num) {
//                    System.out.println();
//                    System.out.println("Good job, " + name + "! You guessed my number in " + count + " guesses!");
//                    System.out.println();
//                    System.out.println("Would you like to play again? (y or n)");
// 
//                    char charInput = obj.nextLine().charAt(0);
//                    
//                } 
                  
                  
//                  again = obj.nextLine();

               
               
           
           
// 
//     }
// 
// 
// 
// }
