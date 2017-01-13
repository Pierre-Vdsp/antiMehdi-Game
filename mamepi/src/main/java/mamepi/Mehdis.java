package mamepi;

import java.awt.Graphics;
import java.awt.Image;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameEntity;

public class Mehdis implements GameEntity {

	GameCanvas canvas ;
	
	public Mehdis(GameCanvas canvas) {
		this.canvas = canvas ;
	}

	public void draw(Graphics g) {
		DrawableImage img = new DrawableImage("/images/images.jpeg", canvas) ;
		img.draw(g);
	}

	public boolean isMovable() {
		return true;
	}
}
