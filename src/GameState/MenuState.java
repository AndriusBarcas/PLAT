package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;




import Manager.Content;
import Manager.GameStateManager;
import Manager.Keys;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage marker;
	
	private Font font;
	
	private int currentOption = 0;
	private String[] options = {
		"START",
		"QUIT"
	};

	public MenuState(GameStateManager gsm) {
		super(gsm);
		
		font = new Font(
				"Century Gothic",
				Font.PLAIN,
				28);
		
	}
	public void init() {
		bg = Content.MENUBG[0][0];
		marker = Content.MARKER[0][0];
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);
		
		g.setFont(font);
		
		
		
		for(int i = 0; i < options.length; i++) {
			if(i == currentOption) {
				g.setColor(Color.WHITE);
				g.drawImage(marker, 340, 375 + i * 40, null);
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 375, 400 + i * 40);
		}
		
	}
	public void handleInput() {
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) {
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) {
			selectOption();
		}
	}
	private void selectOption() {
		if(currentOption == 0) {
			gsm.setState(GameStateManager.PLAY);
		}
		if(currentOption == 1) {
			System.exit(0);
		}
	}
}

