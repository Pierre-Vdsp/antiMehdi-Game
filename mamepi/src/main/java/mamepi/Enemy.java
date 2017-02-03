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
import gameframework.motion.MoveStrategy;
import gameframework.motion.overlapping.Overlappable;

public abstract class Enemy extends GameMovable implements Overlappable, GameEntity, Drawable{
	protected SpriteManagerDefaultImpl sprite;
	protected int size;
	public abstract String getStringImagePath();
	public abstract MoveStrategy getNewMoveStrategy(GameCanvas canvas);
	
	public void init(GameCanvas canvas, GameData data){
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage(this.getStringImagePath(), canvas), this.size, 1);
		this.sprite.reset();
		this.position = new Point(this.random(canvas.getWidth()-size, 0), -size);
		this.moveDriver.setStrategy(this.getNewMoveStrategy(canvas));	
	}
	
	public int random(int higher, int lower){
		return (int)(Math.random() * (higher-lower)) + lower;
	}

	public int getNewSize() {
		return this.size;
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(this.size, this.size);
	}
	
	public void draw(Graphics g) {
		this.sprite.draw(g, this.position);
	}
	
	public boolean isMovable() {
        return true;
    }
}