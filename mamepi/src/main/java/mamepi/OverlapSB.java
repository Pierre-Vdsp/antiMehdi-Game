package mamepi;

import java.util.Vector;

import gameframework.game.GameData;
import gameframework.motion.overlapping.*;

public class OverlapSB extends OverlapRulesApplierDefaultImpl {
	
	protected GameData data;
				
	public void overlapRule(Migale  e1, Player e2){
			data.getUniverse().removeGameEntity(e1);
			decreaseLife();
			resetPlayer(e2);
	}
		
	public void overlapRule(Mehdis e1, Player e2){
				data.getUniverse().removeGameEntity(e1);
				data.getScore().setValue(data.getScore().getValue() + e1.getScore());
		        e2.increaseSize(2);
	}
	
	public void overlapRule(MehdisVie e1, Player e2){
		data.getUniverse().removeGameEntity(e1);
		data.increaseLife(1);
}
	
	public void overlapRule(BorderLimit e1, Player e2){
		e2.setSpeedVector(null);
}
	
	public void resetPlayer(Player e1){
		if (this.data.getLife().getValue() == 0 ){
			data.getUniverse().removeGameEntity(e1);
			System.exit(0);
		}else {
	        e1.resetPosition();
		}
	}
	public void setGameData(GameData data) {
		this.data = data;		
	}

	public void applyOverlapRules(Vector<Overlap> overlaps) {
		super.applyOverlapRules(overlaps);
	}
	
	public void decreaseLife(){
		this.data.decreaseLife(1);
	}

}
