package tests;

import Java.DragonCave;
import Java.GuessTheNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {


    @Test
    void TestingGuessRange() {

        GuessTheNumber guessingTest = new GuessTheNumber();

        assertTrue(guessingTest.UserGuess() >= 1 && guessingTest.UserGuess() <= 21);

    }
}