package mamepi;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;

public class MigaleTest extends EnemyTest{

	@Override
	public Enemy createInstance(GameCanvas canvas, GameData prmData) {
		return new Migale(canvas, prmData);
	}

	@Override
	public String getExpectedStringPath() {
		return "/images/migale.png";
	}

	@Override
	public int getExpectedSize() {
		return 50;
	}

	@Override
	public int getExpectedScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
