package HumansVsGoblins;

public class Human extends Land  {


        private int health;
        private char h = 'h';
        private int xPosition;
        private int yPosition;

        public int getxPosition() {
                return xPosition;
        }

        public void setxPosition(int xPosition) {
                this.xPosition = xPosition;
        }

        public int getyPosition() {
                return yPosition;
        }

        public void setyPosition(int yPosition) {
                this.yPosition = yPosition;
        }

        public char getH() {
                return h;
        }

        public void setH(char h) {
                this.h = h;
        }

        public int getHealth() {
                return health;
        }

        public void setHealth(int health) {
                this.health = health;
        }


}
