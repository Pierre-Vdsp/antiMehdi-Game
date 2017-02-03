package mamepi;

import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class MehdisVie extends Enemy {

	GameCanvas canvas ;
	
	public MehdisVie(GameCanvas canvas, GameData data) {
		this.canvas = canvas ;
		this.init(canvas, data);
		this.size = 20 ;
		init(canvas, data);
	}

	public boolean isMovable() {
		return true;
	}

	@Override
	public String getStringImagePath() {
		return "/images/worms3.png";
	}

	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(30);
		return ms;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}
}
