package HumansVsGoblins;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[][] gameboard = new String[10][30];  //row(y) is 10 and col(x) is 30

        Land land = new Land();
        Human human = new Human();
        Goblin goblin = new Goblin();

        human.setxPosition(9); //row
        human.setyPosition(15); //col
        goblin.setxPosition(3);
        goblin.setyPosition(15);

        land.buildingGrid(gameboard, human.getxPosition(), human.getyPosition(), goblin.getxPosition(), goblin.getyPosition());

        boolean isDead = false;
        char move = 'n';
        int Gmove = 0;

        int mover = 0;


        while (!isDead) {

            Scanner input = new Scanner(System.in);

            //get humans move
            move = input.nextLine().charAt(0);

            if (move == 'w' && (human.getxPosition() >= 0 && human.getxPosition() < 10)) { //put second half of if statement into goblin position condition too
                human.setxPosition(human.getxPosition() - 2);
            }
            else if (move == 's' && (human.getxPosition() >= 0 && human.getxPosition() < 10)) {
                human.setxPosition(human.getxPosition() + 2);
            }
            else if (move == 'd' && (human.getyPosition() >= 0 && human.getyPosition() < 30)) {
                human.setyPosition(human.getyPosition() + 2);
            }
            else if (move == 'a' && (human.getyPosition() >= 0 && human.getyPosition() < 30)) {
                human.setyPosition(human.getyPosition() - 2);
            }

            //get goblin's x
            if (mover == 0) {
                if (human.getxPosition() > goblin.getxPosition()) {
                    goblin.setxPosition(goblin.getxPosition() + 1);
                } else {
                    goblin.setxPosition(goblin.getxPosition() - 1);
                }
                mover = 1;
            }
            //get goblin's y
            if (mover == 1) {
                if (human.getyPosition() > goblin.getyPosition()) {
                    goblin.setyPosition(goblin.getyPosition() + 1);
                } else {
                    goblin.setyPosition(goblin.getyPosition() - 1);
                }
                mover = 0;
            }


            land.buildingGrid(gameboard, human.getxPosition(), human.getyPosition(), goblin.getxPosition(), goblin.getyPosition());

            if (human.getxPosition() <= 0) {
                isDead = true;
                System.out.println();
                System.out.println("You made it to the other side. Congrats!");
            }
            if ((human.getxPosition() == goblin.getxPosition()) && (human.getyPosition() == goblin.getyPosition())) {
                isDead = true;
                System.out.println();
                System.out.println("You died!");
            }



        }
















    }
}
