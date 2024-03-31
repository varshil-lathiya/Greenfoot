import greenfoot.*;

public class Score extends Actor {
    public static int score;

    public Score() {
        score = 0;
    }

    public void act() {
        World myWorld = getWorld();
        GreenfootImage textImage = new GreenfootImage("Score: " + score, 36, Color.BLACK, Color.RED);
        getWorld().getBackground().drawImage(textImage, 10, 10);

        // Check for win condition
        if (score >= 25 && myWorld instanceof MyWorld) {
            ((MyWorld) myWorld).showWinGame();
        }
    }

    public static void add(int num) {
        score += num;
    }
}
