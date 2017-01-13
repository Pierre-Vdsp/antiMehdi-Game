package mamepi;

import java.util.Timer;
import java.util.TimerTask;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class LevelAntiMehdi extends GameLevelDefaultImpl {

	protected static int nbEnemies = 30;
	public static int count = 0;
	public static Timer timer = new Timer();
	
	public LevelAntiMehdi(GameData data) {
		super(data);
	}
	
	protected void init() {
		TimerTask task = this.getTimerTask();
		timer.scheduleAtFixedRate(task, 0, 2000);
		Player p = new Player(data.getCanvas(),data);
		data.getUniverse().addGameEntity(p);
		data.getUniverse().addGameEntity(new Mehdis(data.getCanvas(), data));
		
		this.gameBoard = new AntiMehdisViewPort(this.data);

	}
	
	public TimerTask getTimerTask() {
		return new TimerTask()
		{
			@Override
			public void run() 
			{
				count++;
				count++;
			     if (count >= nbEnemies) {
			         timer.cancel();
			         timer.purge();
			         return;
			     }
				data.getUniverse().addGameEntity(new Mehdis(data.getCanvas(), data));
				data.getUniverse().addGameEntity(new Mehdis(data.getCanvas(), data));
			}	
		};
	}
}