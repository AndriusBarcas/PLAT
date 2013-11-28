package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



import Manager.Content;
import tilemap.TileMap;

public class zaidejas extends Entity {
	
	// sprites
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	
	// animation
	private final int DOWN = 0;
	private final int LEFT = 1;
	private final int RIGHT = 2;
	private final int UP = 3;

	private int ejimai = 0 ;
	
	private boolean hasBow;
	private boolean hasAxe;

	

public zaidejas(TileMap tm) {
	
	super(tm);
			
	width = 30;
	height = 30;
	cwidth = 30;
	cheight = 30;
	
	moveSpeed = 2;
	
	downSprites = Content.zaidejas[0];
	leftSprites = Content.zaidejas[1];
	rightSprites = Content.zaidejas[2];
	upSprites = Content.zaidejas[3];
	
	animation.setFrames(downSprites);
	animation.setDelay(10);
}

private void setAnimation(int i, BufferedImage[] bi, int d) {
	currentAnimation = i;
	animation.setFrames(bi);
	animation.setDelay(d);
}
public void gotBow() { hasBow = true; }
public void gotAxe() { hasAxe = true; }
public boolean hasBow() { return hasBow; }
public boolean hasAxe() { return hasAxe; }
public int getEjimai() { return maxejimai - ejimai; }


//Keyboard input. Moves the player.
	public void setDown() {
			super.setDown();
			ejimai = super.ejimai;
	}
	public void setLeft() {
			super.setLeft();
			ejimai = super.ejimai;
	}
	public void setRight() {
			super.setRight();
			ejimai = super.ejimai;
	}
	public void setUp() {
			super.setUp();
			ejimai = super.ejimai;
	}

	public void setAction() {
		if(hasAxe) {
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 21) {
				tileMap.setTile(rowTile - 1, colTile, 1);
			//	JukeBox.play("tilechange");
			}
			if(currentAnimation == DOWN && tileMap.getIndex(rowTile + 1, colTile) == 21) {
				tileMap.setTile(rowTile + 1, colTile, 1);
		//		JukeBox.play("tilechange");
			}
			if(currentAnimation == LEFT && tileMap.getIndex(rowTile, colTile - 1) == 21) {
				tileMap.setTile(rowTile, colTile - 1, 1);
		//		JukeBox.play("tilechange");
			}
			if(currentAnimation == RIGHT && tileMap.getIndex(rowTile, colTile + 1) == 21) {
				tileMap.setTile(rowTile, colTile + 1, 1);
		//		JukeBox.play("tilechange");
			}
		}
	}
	
public void update() {
		

		// set animation
		if(down) {
				setAnimation(DOWN, downSprites, 10);
			}
		if(left) {
				setAnimation(LEFT, leftSprites, 10);
		}
		if(right) {
				setAnimation(RIGHT, rightSprites, 10);
		}
		if(up) {
				setAnimation(UP, upSprites, 10);	
		}
		
		// update position
		super.update();
		
	}
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
	public void reset(){
		super.reset(); 
		ejimai = super.ejimai;
	}
	
}
