package GameState;

import java.awt.Graphics2D;


import java.awt.image.BufferedImage;

import Manager.Keys;
import Manager.Content;
import Manager.GameStateManager;



public class EndState extends GameState {
	
	private BufferedImage End;
	
	public EndState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		End = Content.END[0][0];
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {

		g.drawImage(End, 0, 0, null);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}
