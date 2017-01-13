package mamepi;

import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class Mehdis extends Enemy {

	GameCanvas canvas ;
	
	public Mehdis(GameCanvas canvas, GameData data) {
		this.canvas = canvas ;
		this.init(canvas, data);
		this.size = 50 ;
		init(canvas, data);
	}

	public boolean isMovable() {
		return true;
	}

	@Override
	public String getStringImagePath() {
		return "/images/images.jpeg";
	}

	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(this.random(15, 5));
		return ms;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO don't know don't care
	}
}
