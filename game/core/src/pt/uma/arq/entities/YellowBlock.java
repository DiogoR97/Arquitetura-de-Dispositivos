package pt.uma.arq.entities;

import pt.uma.arq.game.Animator;
import sun.jvm.hotspot.opto.Block;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class YellowBlock extends BlockExample {
    public YellowBlock(SpriteBatch batch){
        this.x = 0;
        this.y = 0;
        this.score = 5;
        collided = false;
        animator = new Animator(batch, "yellow.png",2,1);
        animator.create();
        boundingBox= new Rectangle(0 , 0, animator.getWidth(), animator.getHeight());
    }

}
