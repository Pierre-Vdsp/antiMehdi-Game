package mamepi;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;

public class Main {

	public static void main(String[] args) {
		
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);

		data.addLevel(new LevelAntiMehdi(data));
					
		AntiMehdiGame game = new AntiMehdiGame(data);		

		GameWindow window = new GameWindowMamepi("AntiMehdi", data.getCanvas(), data);

		window.createGUI();
		game.start();

	}

}
