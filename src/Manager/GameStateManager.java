package Manager;

import java.awt.Graphics2D;



import GameState.MenuState;
import GameState.PlayState;
import GameState.GameState;

//import GameState.PauseState;


public class GameStateManager {

	//private boolean paused;
	//private PauseState pauseState;
	
	
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 2;
	public static final int MENU = 0;
	public static final int PLAY = 1;
	
	
	public GameStateManager() {
		gameStates = new GameState[NUM_STATES];
		setState(MENU);
	}
	
	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == MENU) {
			gameStates[i] = new MenuState(this);
			gameStates[i].init();
		}
		else if(i == PLAY) {
			gameStates[i] =  new PlayState(this);
			gameStates[i].init();
		}
	}
		public void unloadState(int i) {
			gameStates[i] = null;
		}
		
		public void update() {
			if(gameStates[currentState] != null) {
				gameStates[currentState].update();
			}
		}
		
		public void draw(Graphics2D g) {
			if(gameStates[currentState] != null) {
				gameStates[currentState].draw(g);
			}
		}
}
