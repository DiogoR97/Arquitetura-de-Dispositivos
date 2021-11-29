package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import pt.uma.arq.game.Animator;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.graalvm.compiler.nodes.cfg.Block;

import java.awt.*;

public class PlayerPaddle {
    protected int x,y;
    protected Animator animator;
    protected Rectangle boundingBox;
    protected int score;



    public PlayerPaddle(SpriteBatch batch){
        this.x = Gdx.graphics.getWidth()/2;
        this.y = 30;
        this.score = 0;
        animator = new Animator(batch, "full_paddle.png",6,1);

    }

        //method

    public void create(){
        animator.create();
        boundingBox= new Rectangle(x , y, animator.getWidth(), animator.getHeight());

    }

    public void render(){

        animator.render(x,y);
    }

    public void manageUserInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if( x < 10) {
                return;
            }
            x -= 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(x > 1200){
                return;
            }
            x += 10;
        }
        boundingBox.setLocation(x, y);
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

