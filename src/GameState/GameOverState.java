package GameState;

import java.awt.Graphics2D;


import java.awt.image.BufferedImage;

import Manager.Keys;
import Manager.Content;
import Manager.GameStateManager;



public class GameOverState extends GameState {
	
	private BufferedImage GAMEOVER;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		GAMEOVER = Content.GAMEOVER[0][0];
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {

		g.drawImage(GAMEOVER, 0, 0, null);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}
