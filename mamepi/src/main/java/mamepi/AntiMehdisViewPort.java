package mamepi;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class AntiMehdisViewPort extends GameUniverseViewPortDefaultImpl {

	public AntiMehdisViewPort() {}

	public AntiMehdisViewPort(GameData data) {
		super(data);
	}

	@Override
	protected URL backgroundImage(){
		return this.getClass().getResource("/images/worms.jpg");
	}
}
