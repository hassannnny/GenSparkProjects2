package tests;

import Java.DragonCave;
import Java.GuessTheNumber;
import Java.Main;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DragonCaveTest {

    @Test
    void TestCorrectMessage() {

        DragonCave test = new DragonCave();


        String testMessage = "You approach a cave... \n\nIt is dark and spooky..." +
                "A large dragon jumps out in front of you! He opens his jaws and...\n\n" +
                "Gobbles you down in one bite!";


        assertSame(test.DragonCaveCalculation("returned message"), testMessage);





    }
}