package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Manager.Content;
import tilemap.TileMap;


public class Daiktai extends Entity{

	private BufferedImage sprite;
	private int type;
	public static final int BOW = 0;
	public static final int AXE = 1;
	
	public Daiktai(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 16;
		cwidth = cheight = 12;
	}
	
	public void setType(int i) {
		type = i;
		if(type == BOW) {
          	sprite = Content.DAIKTAI2[0][0];
		}
		else if(type == AXE) {
			sprite = Content.DAIKTAI[1][1];
		}
	}
	
	public void collected(zaidejas p) {
		if(type == BOW) {
			p.gotBow();
		}
		if(type == AXE) {
     		p.gotAxe();
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
}
