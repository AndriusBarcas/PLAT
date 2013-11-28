package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Manager.Content;
import tilemap.TileMap;

public class Enemy extends Entity {
	
	private BufferedImage sprite;
	private int type;
	public static final int WOLF = 0;
	
	public Enemy(TileMap tm){
		super(tm);
		type = -1;
		width = height = 30;
		cwidth = cheight = 24;
	}
	
	public void setType(int i) {
		type = i;
		if(type == WOLF) {
			sprite = Content.ENEMY[1][0];
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
	public void update() {}

}
