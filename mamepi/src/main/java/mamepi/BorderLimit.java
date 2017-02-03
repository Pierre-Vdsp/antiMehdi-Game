package mamepi;


import gameframework.drawing.GameCanvas;
import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.game.GameData;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Point;

public class BorderLimit implements MoveBlocker, GameEntity,Drawable {

	protected Point position;
	protected GameCanvas canvas;
	protected DrawableImage img;
	
	public  BorderLimit (GameData data, int x, int y) {
		this.canvas = data.getCanvas();
		this.img = new DrawableImage("/images/wall.png",this.canvas);
		this.position = new Point(x,y);
	}
	
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}


	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}

	public boolean isMovable() {
		// TODO Auto-generated method stub
		return false;
	}
}
