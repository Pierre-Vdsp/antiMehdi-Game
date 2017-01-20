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
    
    final protected int WAZO_SIZE = 70;

    public Player(GameCanvas canvas, GameData data) {
        this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/images/player.png", canvas), WAZO_SIZE, 1);
        this.position = new Point(0, canvas.getHeight()-WAZO_SIZE);
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
		
}
