package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        boolean again = true;
        String again2 = "y";

        while (again) {
            String[][] grid = new String[10][21];

            //building grid
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {

                    grid[row][col] = " ";

                    if ((col == 10 || col == 20) && row == 0) {
                        grid[row][col] = "+";
                    }

                    if ((row == 0) && (col >= 11 && col <= 19)) {
                        grid[row][col] = "-";
                    }

                    if (col == 20 && (row >= 1 && row <= 9)) {
                        grid[row][col] = "|";
                    }

                    if (row == 9 && col >= 17) {
                        grid[row][col] = "=";
                    }
                }
            }

            String guess = "";
            String missedLetters = "";
            ArrayList<String> word = new ArrayList<>();
            Scanner input = new Scanner(System.in);
            String actual = "";
            String guessHolder = "";
            int winCounter = 0;
            int random = (int) (Math.random() * 230) + 1;

            ArrayList<String> actualHolder = new ArrayList<>();


            //getting random word
            actual = randomWord(actual, random);


            //printing the default grid
            printingGrid(grid);
            System.out.println();

            //add _ to word
            for (int i = 0; i < actual.length(); i++) {
                word.add("_");
            }

            //copying actual to String actualHolder
            for (int k = 0; k < actual.length(); k++) {
                actualHolder.add(actual.charAt(k) + "");
            }

            int count = 1;

            System.out.println("H A N G M A N");
            System.out.println("Missed Letters: " + missedLetters);
            System.out.println();
            printingWord(word);
            System.out.println();
            System.out.println("Guess a letter");
            System.out.println();


            //in the game loop
            while (count <= 6) {
            
                
                guess += input.next().charAt(0);

                if (!actualHolder.contains(guess)) {

                    if (missedLetters.contains(guess)) {
                        System.out.println("You have already guessed that number. Try again");
                        count--;
                        guess = "";
                    } else {
                        missedLetters = lettersMissed(guess, missedLetters);
                        grid = doesntContain(grid, count);
                        guess = "";
                    }
                }
                else if (actualHolder.contains(guess)) {

                    if (guessHolder.contains(guess)) {
                        guessHolder += guess;
                        System.out.println("You have already guessed that number. Try again");
                    }
                    else {
                        winCounter = doesContain(guess, word, actualHolder, winCounter);
                        guess = "";
                    }
                }

                if (winCounter == actual.length()) {
                    count = 7;
                    System.out.println();
                    printingWord(word);
                    System.out.println();
                    System.out.println("Yes! The secret word is " + actual + ". You won!");
                }
                else if (count != 6) {


                    //printing grid
                    printingGrid(grid);

                    System.out.println();
                    System.out.println("Missed Letters: " + missedLetters);
                    System.out.println();
                    printingWord(word);
                    System.out.println("Guess a letter");
                    System.out.println();

                    count++;
                }
                else if (count == 6) {
                    //printing grid
                    printingGrid(grid);

                    System.out.println();
                    System.out.println("Missed Letters: " + missedLetters);
                    System.out.println();
                    printingWord(word);
                    System.out.print("The secret word is " + actual);
                    count++;
                }
            }

            System.out.println();
            System.out.println("Would you like to play again?");

            again2 += input.next().charAt(0);

            if (again2.contains("n")) {
                again = false;
            }
        }
        
   }

   //getting random word
    public static String randomWord(String actual, int random) {

        int count = 0;

        String holder = "";
        
        try {
            File file = new File("C:\\Users\\hassa\\IdeaProjects\\GenSparkProjects\\MostCommon3LetterWords");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine() && count <= random) {
                
                if (count == random) {

                    actual = reader.nextLine().toLowerCase(Locale.ROOT);
                    break;
                }
                else {
                
                    holder = reader.nextLine();
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return actual;
    }
   
    //first else statement
    public static String lettersMissed(String guess, String missedLetters) {

        missedLetters += guess;

        return missedLetters;
    }

    public static String[][] doesntContain(String[][] grid, int i) {

        //head
        if (i == 1) {
            grid[2][10] = "O";
        }
        //body
        else if (i == 2) {
            for (int row = 3; row < 7; row++) {
                grid[row][10] = "|";
            }
        }
        //right arm
        else if (i == 3) {
            for (int col = 11; col <= 13; col++) {
                grid[4][col] = "_";
            }
        }
        //left arm
        else if (i == 4) {
            for (int col = 9; col >= 7; col--) {
                grid[4][col] = "_";
            }
        }
        //5 right leg
        else if (i == 5) {
            grid[7][11] = "\\";
            grid[8][12] = "\\";
        }
        //6 left leg
        else if (i == 6) {
            grid[7][9] = "/";
            grid[8][8] = "/";
        }

        return grid;
    }

    //second else statement
    public static int doesContain(String guess, ArrayList<String> word, ArrayList<String> actualHolder, int winCounter) {

        //copy character from guess to word
        for (int i = 0; i < actualHolder.size(); i++) {

            if (actualHolder.get(i).equals(guess)) {
                word.set(i, guess);
            }
        }
        //setting guessed chars to 'nothing'
        for (int i = 0; i < actualHolder.size(); i++) {

            if (actualHolder.get(i).equals(guess)) {
                actualHolder.set(i, "nothing");
                winCounter++;

            }
        }
        return winCounter;
    }

    //printing grid
    public static String[][] printingGrid(String[][] grid) {

        for (String[] strings : grid) {
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i]);
            }
            System.out.println();
        }

        return grid;
    }
    
    //printing word
    public static ArrayList<String> printingWord(ArrayList<String> word) {

        for (int i = 0; i < word.size(); i++) {
            System.out.print(word.get(i)+ " ");
        }
        System.out.println();
    
        return word;
    
    
    }

}