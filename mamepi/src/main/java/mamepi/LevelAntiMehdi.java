package mamepi;

import java.util.Timer;
import java.util.TimerTask;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class LevelAntiMehdi extends GameLevelDefaultImpl {

	protected static int nbEnemies = 60;
	public static int count = 0;
	public static Timer timer = new Timer();
	
	public LevelAntiMehdi(GameData data) {
		super(data);
		OverlapSB rules = new OverlapSB();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}
	
	protected void init() {
		TimerTask task = this.getTimerTask();
		timer.scheduleAtFixedRate(task, 0, 2000);
		Player p = new Player(data.getCanvas(),data);
		//this.initBorders();
		data.getUniverse().addGameEntity(p);
		data.getUniverse().addGameEntity(new Mehdis(data.getCanvas(), data));
		data.getUniverse().addGameEntity(new Migale(data.getCanvas(), data));
		
		this.gameBoard = new AntiMehdisViewPort(this.data);


	}
	
	public TimerTask getTimerTask() {

		return new TimerTask()
		{
			int vie = 0;
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
				data.getUniverse().addGameEntity(new Migale(data.getCanvas(), data));
				if (++vie >=10){
					data.getUniverse().addGameEntity(new MehdisVie(data.getCanvas(), data));
					data.getUniverse().addGameEntity(new Migale(data.getCanvas(), data));
					vie = 0;
				}
			}	
		};
	}
	
	private void initBorders() {
		for (int i = 0; i <  this.data.getConfiguration().getNbRows(); i++){
			universe.addGameEntity(new BorderLimit(data, 0, i* this.spriteSize));
			int n = this.data.getConfiguration().getNbRows()-i;
			universe.addGameEntity(new BorderLimit(data,this.spriteSize*( this.data.getConfiguration().getNbColumns() - 1),n* this.spriteSize));
		}
		for (int i = 0; i < this.data.getConfiguration().getNbColumns(); i++){
			universe.addGameEntity(new BorderLimit(data,this.spriteSize*i, 0));
			int n = this.data.getConfiguration().getNbColumns()-i;
			universe.addGameEntity(new BorderLimit(data, this.spriteSize*n,this.spriteSize*(this.data.getConfiguration().getNbRows()- 1)));
		}
						
	}

}