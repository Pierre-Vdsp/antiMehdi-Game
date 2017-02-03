package mamepi;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class GameLevelAntiMehdi extends GameLevelDefaultImpl {


	public GameLevelAntiMehdi(GameData data, int minimumDelayBetweenCycles) {
		super(data, minimumDelayBetweenCycles);
	}

	public GameLevelAntiMehdi(GameData data) {
		super(data);
	}
	
	protected void init() {
		data.getUniverse().addGameEntity(new Mehdis(data.getCanvas(), data));
		
		this.gameBoard = new AntiMehdisViewPort(data);

	}
}