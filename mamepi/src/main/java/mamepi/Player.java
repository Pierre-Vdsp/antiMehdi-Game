package mamepi;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyKeyboard8Dir;
import gameframework.motion.SpeedVector;
import gameframework.motion.overlapping.Overlappable;

public class Player extends GameMovable implements Overlappable, GameEntity, Drawable {

    protected SpriteManagerDefaultImpl sprite;
    protected DrawableImage imgsprite;
    protected int WAZO_SIZE = 70;
    protected Point initialPoint; 
    public Player(GameCanvas canvas, GameData data) {
    	imgsprite = new DrawableImage("/images/player.png", canvas);
        this.sprite = new SpriteManagerDefaultImpl(imgsprite, WAZO_SIZE, 1);
        this.initialPoint =  new Point((canvas.getWidth()-WAZO_SIZE)/2, canvas.getHeight()-WAZO_SIZE);
        this.position = new Point(this.initialPoint);
        this.sprite.reset();

        MoveStrategyKeyboard direction = new MoveStrategyKeyboard8Dir(false, new SpeedVector(new Point(0,0), 25));
        
        this.moveDriver = new GameMovableDriverDefaultImpl();        
        canvas.addKeyListener(direction);
        this.moveDriver.setStrategy(direction);
    }

    public void draw(Graphics g) {
        this.sprite.draw(g, this.position);
    }

    public boolean isMovable() {
        return true;
    }
    
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.WAZO_SIZE, this.WAZO_SIZE);
        return rectangle;
	}
	
	public Point getPosition(){
		return this.position;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}
	
	public void resetPosition(){
        this.position = new Point(this.initialPoint);
	}

	public void increaseSize(int i) {
		this.sprite = new SpriteManagerDefaultImpl(imgsprite, WAZO_SIZE+=i, 1);
		
	}
		
}
