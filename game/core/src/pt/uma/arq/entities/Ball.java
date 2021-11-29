package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class Ball {
    protected Animator animator;
    protected Rectangle boundingBox;
    protected int score;
    protected int x, y;
    private int signalY;
    private int signalX;
    private PlayerPaddle paddle;




    public Ball(SpriteBatch batch){
        this.x = Gdx.graphics.getWidth()/2;
        this.y = 70;
        animator = new Animator(batch, "ball.png", 2,2);
        this.signalY= 1;
        this.signalX= 1;
        this.paddle = new PlayerPaddle(batch);

    }

    public void create(){
        animator.create();
        boundingBox= new Rectangle(x , y, animator.getWidth(), animator.getHeight());

    }

    public void render(){
        animator.render(x,y);
    }

    public void ballMovement(PlayerPaddle paddle){


        if(y > Gdx.graphics.getHeight() -20) {
            signalY = -1;

        }
        if(checkCollision(paddle)) {
            signalY = 1;
        }
        y += 5* signalY;

        if(x < 10){
            signalX = 1;
        }
        if( x > Gdx.graphics.getWidth() - 20){
            signalX = -1;
        }
         x += 5* signalX;

        boundingBox.setLocation(x, y);

    }

    public boolean checkCollision(PlayerPaddle paddle){
        return this.boundingBox.intersects(paddle.getBoundingBox());
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public int getSignalY() {
        return signalY;
    }

    public void setSignalY(int signalY) {
        this.signalY = signalY;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        this.boundingBox.setLocation(x,y);
    }
}
