package HumansVsGoblins;

import java.util.Arrays;

public class Land  {


    public void buildingGrid(String[][] gameboard, int HumanxPosition, int HumanyPosition, int GoblinxPosition1, int GoblinyPosition1) {

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if ((i == HumanxPosition) && (j == HumanyPosition)) {
                    gameboard[i][j] = "h";
                }
                else if ((i == GoblinxPosition1) && (j == GoblinyPosition1)) {
                    gameboard[i][j] = "g";
                }
                else {
                    gameboard[i][j] = "-";
                }
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
    }
}


