package mamepi;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameframework.gui.GameMenuBar;

public class GameMenuBarAntiMehdis extends GameMenuBar {

	@Override
	public MenuBar getComponent(){
		MenuBar menu = super.getComponent() ;
		Menu levels = new Menu("levels");
		MenuItem antimehd = new MenuItem("antiMehdis");
		menu.add(levels);

		antimehd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**/
			}
		});
		
		levels.add(antimehd);

		return menu ;
	}

}
