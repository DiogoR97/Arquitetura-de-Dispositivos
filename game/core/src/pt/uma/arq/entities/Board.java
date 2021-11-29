package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.GreenBlock;
import pt.uma.arq.entities.PurpleBlock;
import pt.uma.arq.entities.RedBlock;
import pt.uma.arq.entities.YellowBlock;

import java.util.ArrayList;

public class Board {
    private SpriteBatch batch;
    private ArrayList<BlockExample> blockList;
    private Ball ball;



    public Board(SpriteBatch batch){
        this.batch = batch;
        blockList = new ArrayList<BlockExample>();
        ball = new Ball(batch);
    }


    public void create(){
        for (int linha = 0; linha < 4; linha++){
            for (int i = 0; i <= 20; i++){
                switch (linha){
                    case 0:
                        GreenBlock blockExample = new GreenBlock(batch);
                        blockExample.setLocation(100 + ((blockExample.getWidth() + 5) *i), 650);
                        blockList.add(blockExample);
                        break;
                    case 1:
                        PurpleBlock blockExample1 = new PurpleBlock(batch);
                        blockExample1.setLocation(100 + ((blockExample1.getWidth() + 5) *i), 650 - linha*40);
                        blockList.add(blockExample1);
                        break;
                    case 2:
                        RedBlock blockExample2 = new RedBlock(batch);
                        blockExample2.setLocation(100 + ((blockExample2.getWidth() + 5) *i), 650 - linha*40);
                        blockList.add(blockExample2);
                        break;
                    case 3:
                        YellowBlock blockExample3 = new YellowBlock(batch);
                        blockExample3.setLocation(100 + ((blockExample3.getWidth() + 5) *i), 650 - linha*40);
                        blockList.add(blockExample3);
                        break;
                }
            }
        }
    }

    public void render(){
        for (BlockExample blockExample : blockList){
            blockExample.render();

        }
    }

    public void checkCollisions(Ball ball){
        for(int l = 0; l < 4; l++)
            for(int i = 0 ; i < 20; i++){
                if(blockList.get(i).getBoundingBox().intersects(ball.getBoundingBox()))
                    ball.setSignalY(-1);
        }
    }

}
