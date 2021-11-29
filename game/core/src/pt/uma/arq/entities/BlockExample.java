package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.graalvm.compiler.nodes.cfg.Block;
import pt.uma.arq.game.Animator;

import java.awt.*;

public abstract class BlockExample {
    protected int x,y;
    protected Animator animator;
    protected Rectangle boundingBox;
    protected int score;
    protected boolean collided;


   /* public BlockExample(SpriteBatch batch){
        this.x = 0;
        this.y = 0;
        this.score = 5;
        collided = false;
        animator = new Animator(batch, "green.png",2,1);
        animator.create();
        boundingBox= new Rectangle(0 , 0, animator.getWidth(), animator.getHeight());
    }*/

    //method
    /*public boolean checkCollision(Ball ball){
        this.
    }*/
    public void render(){
        animator.render(x,y);
    }
    public boolean isCollided(){
        return collided;
    }

    public int getWidth(){
        return animator.getWidth();
    }
    public int getHeight(){
        return animator.getHeight();
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        this.boundingBox.setLocation(x,y);
    }
}
