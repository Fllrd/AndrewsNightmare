package com.fllrd.Entity;

import java.awt.Graphics2D;

import com.fllrd.TileMap.TileMap;


public abstract class EnemyProjectile extends MapObject {
	
	protected boolean hit;
	protected boolean remove;

	public EnemyProjectile(TileMap tm) {
		super(tm);
	}

	public boolean shouldRemove() { return remove; }

	public abstract void update();
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}
