import greenfoot.*; 

public class Flappybird extends Actor {
    private double g = 1; 
    private int y = 300;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false;

    public Flappybird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }

    public void act() {
        if(spacePressed()){
            g = -2;
        }
        g += 0.1; 
        y += g; 
        setLocation(getX(), (int)(y));
        
        if(isTouchpipe()){
            isalive = false;
        }
        if(isAtEdge()){
            Greenfoot.playSound("peng.mp3");
            isalive = false;
        }
        if(!isalive){
            getWorld().addObject(new Gameover(), 400, 200);
            getWorld().removeObject(this);
        }
        if(isacross && isalive){
            hasaddscore = true; // Set hasaddscore to true when bird is across the pipe
        }
        if(hasaddscore && !isacross && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
            hasaddscore = false; // Reset hasaddscore once score is incremented
        }
    }

    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space")){
            if(!haspressed){
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true; 
        } else {
            haspressed = false;
        }
        return pressed;
    }
    
    public boolean isTouchpipe(){
        isacross = false;
        for(Pipe pipe : getWorld().getObjects(Pipe.class)){
            if(Math.abs(pipe.getX() - getX()) < 60 ){
                if(Math.abs(pipe.getY() + 30 - getY()) > 37){
                    Greenfoot.playSound("peng.mp3");
                    isalive = false;
                }
                isacross = true; 
            }
        }
        return !isalive;
    }
}
