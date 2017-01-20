package mamepi;

import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class Migale extends Enemy {

	GameCanvas canvas ;
	
	public Migale(GameCanvas canvas, GameData data) {
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
		return "/images/migale.png";
	}

	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(this.random(20, 5));
		return ms;
	}

}
