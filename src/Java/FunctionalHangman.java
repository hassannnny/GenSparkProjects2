package Java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FunctionalHangman {

    public static void main(String[] args) throws IOException {

        int count = -1; int counter = 0; int random = (int) (Math.random() * 230) + 1; int score = 0;
        String again = "y"; String guess = ""; String guessHolder = ""; String name = "";
        String missedLetters = ""; String actual = "";
        Scanner input = new Scanner(System.in);
        ArrayList<String> word = new ArrayList<>();
        List<String> winCounter = new ArrayList<>();
        List<String> actualHolder = new ArrayList<>();
        actual = gettingRandomWord();
        word = adding_ToWord(actual);
        actualHolder = addingActualToActualHolder(actual, actualHolder);

        System.out.println("Enter you name: ");

        name = input.nextLine();

        while (count <= 6 && !again.contains("n")) {

            //reset
            if (count == -1) {
                guess = "";
                input = new Scanner(System.in);
                missedLetters = "";
                actual = "";
                actual = gettingRandomWord();
                word.clear();
                word = adding_ToWord(actual);
                guessHolder = "";
                winCounter.clear();
                actualHolder = addingActualToActualHolder(actual, actualHolder);
                count++;
                updatingGrid(count);


            }
            //in game
            if (count > -1 && count < 6 && winCounter.size() < actual.length())  {


                System.out.println("H A N G M A N");
                System.out.println("Missed Letters: " + missedLetters);
                System.out.println();
                System.out.println(word);
                System.out.println();
                System.out.println("Guess a letter");
                System.out.println();

                guess = input.nextLine();

                score++;

                //DoesntContain
                if (!actualHolder.contains(guess)) {

                    if (missedLetters.contains(guess)) {
                        System.out.println("You have already guessed that number. Try again");
                        guess = "";
                    } else {
                        missedLetters = lettersMissed(guess, missedLetters);
                        count++;
                        updatingGrid(count);
                        guess = "";

                    }
                }
                //Contains
                else if (actualHolder.contains(guess)) {

                    if (missedLetters.contains(guess)) {
                        System.out.println("You have already guessed that number. Try again");
                    } else {
                        //doesContain
                        doesContainPartTwo(guess, word, actualHolder, counter);
                        doesContainPartOne(guess, word, actualHolder, winCounter);

                        guess = "";
                    }
                }
            }
            //You won
            else if (winCounter.size() == actual.length()) {

                count = 7;
                System.out.println();
                updatingGrid(count);
                System.out.println();
                System.out.println("Good job " + name + "! The secret word is " + actual + "\nYou got the word in " + score + " guesses!");
                writingBestScores(name, score);
                gettingBestScore(name, score);
                System.out.println();
                System.out.println("Would you like to play again?");

                again += input.next().charAt(0);

                count = -1;
            }
            //You lost
            else if (count == 6) {

                System.out.println();
                System.out.println("Missed Letters: " + missedLetters);
                System.out.println();
                System.out.println(word);
                System.out.println();
                System.out.println("The secret word is " + actual + ".");

                System.out.println();
                System.out.println("Would you like to play again?");

                again += input.next().charAt(0);

                count = -1;

            }
        }
    }

    public static String gettingBestScore(String name, int score) throws IOException {

        int min = 0;
        boolean best = false;

        List<String> readingBestScores = Files.readAllLines(Paths.get("C:\\Users\\hassa\\IdeaProjects\\GenSparkProjects\\src\\BestScores"));

        List<String[]> split = readingBestScores.stream()
                .map(string -> string.split(" "))
                .collect(Collectors.toList());

        List<Integer> theScores = split.stream()
                .map(scores -> Integer.parseInt(scores[1]))
                .collect(Collectors.toList());

        min = theScores.stream()
                .min(Integer::compare).get();

        final int actualMin = min;

        //getting the string[] with the min number
        List<String[]> theBest = split.stream()
                .filter(string -> string[1].equals(String.valueOf(actualMin)))
                .collect(Collectors.toList());

        best = min > score;

        if (best)
            return "Congrats! " + "You set the best score of " + score;
        else
            return "The best score is" + min;
    }

    public static void writingBestScores(String name, int score) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("BestScores"));

        writer.write(name + " " + score + "\n");
        writer.close();

    }

    public static ArrayList<String> doesContainPartTwo(String guess, ArrayList<String> word, List<String> actualHolder, int counter) {

        if (counter < actualHolder.size()) {

            if (actualHolder.get(counter).equals(guess)) {

                word.set(counter, guess);
            }
            return doesContainPartTwo(guess, word, actualHolder, counter + 1);
        }
        else {
            return word;
        }

    }

    public static void doesContainPartOne(String guess, ArrayList<String> word, List<String> actualHolder, List<String> winCounter) {

        actualHolder.stream()
                .forEach(i -> {
                    if (i.equals(guess)) {
                        actualHolder.set(actualHolder.indexOf(i), "nothing");
                        winCounter.add(guess);
                    }});



    }

    public static void updatingGrid(int count) throws IOException {

        List<String> readingArt = Files.readAllLines(Paths.get("C:\\Users\\hassa\\IdeaProjects\\GenSparkProjects\\src\\art"));

        //head
        if (count == 0) {
            readingArt.subList(0, 9)
                    .forEach(System.out::println);
        }
        //body
        else if (count == 1) {
            readingArt.subList(10, 19)
                    .forEach(System.out::println);
        }
        //right arm
        else if (count == 2) {
            readingArt.subList(20, 29)
                    .forEach(System.out::println);
        }
        //left arm
        else if (count == 3) {
            readingArt.subList(30, 39)
                    .forEach(System.out::println);
        }
        //right leg
        else if (count == 4) {
            readingArt.subList(40, 49)
                    .forEach(System.out::println);
        }
        //left leg
        else if (count == 5) {
            readingArt.subList(50, 59)
                    .forEach(System.out::println);
        }
        else if (count == 6) {
            readingArt.subList(60, 69)
                    .forEach(System.out::println);
        }
    }

    public static String lettersMissed(String guess, String missedLetters) {

        missedLetters += guess;

        return missedLetters;
    }

    public static List<String> addingActualToActualHolder(String actual, List<String> actualHolder) {

        String[] actualArray = actual.split("");

        actualHolder = Arrays.asList(actualArray);

        return actualHolder;

    }

    public static ArrayList<String> adding_ToWord(String actual) {

        ArrayList<String> word = new ArrayList<>(actual.length());

        if (actual.length() == 3) {
            word.add("_");
            word.add("_");
            word.add("_");
        }
        else if (actual.length() == 4) {
            word.add("_");
            word.add("_");
            word.add("_");
            word.add("_");
        }

        return word;

    }

    public static String gettingRandomWord() throws IOException {

        int random = (int) (Math.random() * 230) + 1;

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hassa\\IdeaProjects\\GenSparkProjects\\MostCommon3LetterWords"));

        String actualWord = lines.get(random - 1);

        return actualWord.toLowerCase(Locale.ROOT);


    }





}
