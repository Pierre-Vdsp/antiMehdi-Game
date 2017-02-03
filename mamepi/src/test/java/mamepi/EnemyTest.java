package mamepi;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public abstract class EnemyTest {
	public abstract Enemy createInstance(GameCanvas canvas, GameData data);
	public abstract String getExpectedStringPath();
	public abstract int getExpectedSize();
	public abstract int getExpectedScore();
	
	public Enemy enemy;
	
	@Before
	public void createEnemy() {
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		this.enemy = this.createInstance(data.getCanvas(), data);

	}

	@Test
	public void testIsMovable() {
		assertTrue(this.enemy.isMovable());
	}
	
	@Test
	public void testGetNewSize() {
		assertEquals(this.enemy.getNewSize(), this.getExpectedSize());
	}
	
	@Test
	public void testGetStringImagePath() {
		assertEquals(this.enemy.getStringImagePath(), this.getExpectedStringPath());
	}

	@Test
	public void testGetBoundingBox() {
		assertEquals(this.enemy.getBoundingBox().height, this.getExpectedSize());
		assertEquals(this.enemy.getBoundingBox().width, this.getExpectedSize());
	}

}


