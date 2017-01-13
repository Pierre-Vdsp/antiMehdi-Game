package mamepi;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;

public class GameWindowMamepi extends GameWindow {

	public GameWindowMamepi(String gameName, GameCanvas gameCanvas, GameConfiguration configuration,
			GameStatusBarElement<?>[] elementsStatusBar) {
		super(gameName, gameCanvas, configuration, elementsStatusBar);
		// TODO Auto-generated constructor stub
	}
	
	public GameWindowMamepi(String gameName, GameCanvas gameCanvas, GameData data) {
		super(gameName, gameCanvas, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createGUI() {
		frame.dispose();
		frame.setMenuBar(new GameMenuBarAntiMehdis().getComponent());
		gameCanvas.addTo(frame);
		frame.add(this.statusBar.getContainer(), BorderLayout.NORTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	

}
