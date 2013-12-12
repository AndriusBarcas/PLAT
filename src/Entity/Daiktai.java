package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Manager.Content;
import Manager.GameStateManager;
import tilemap.TileMap;


public class Daiktai extends Entity{

	private BufferedImage sprite;
	private int type;
	public static final int BOOTS = 0;
	public static final int POTION = 1;
	public static final int WINGS = 2;
	public static final int CROWN = 3;
	
	
	public Daiktai(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 30;
		cwidth = cheight = 30;
	}
	
	public void setType(int i) {
		type = i;
		if(type == POTION) {
          	sprite = Content.DAIKTAI[0][1];
		}
		if(type == BOOTS) {
			sprite = Content.DAIKTAI[0][0];
		}
		if(type == WINGS){
			sprite = Content.DAIKTAI[1][0];
		}
		if(type == CROWN){
			sprite = Content.DAIKTAI[1][1];
		}
	}
	
	public void collected(GameStateManager gsm, zaidejas p) {
		if(type == BOOTS){
			p.addEjimai(10);
		}
		if(type == POTION){
			p.addEjimai(5);
		}
		if(type == WINGS){
			p.addEjimai(20);
		}
		if(type == CROWN){
			gsm.setState(GameStateManager.END);
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
}
