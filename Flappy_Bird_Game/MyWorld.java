import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(800, 450, 1);
        addObject(new Flappybird(), 100, 300);
        addObject(new Pipe(), 300, 150);
        addObject(new Pipe(), 600, 150);
        addObject(new Score(), 300, 100);
    }

    public void showWinGame() {
        if (getObjects(WinGame.class).isEmpty()) {
            addObject(new WinGame(), getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }
}