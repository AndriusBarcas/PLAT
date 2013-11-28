package GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Font;



import Manager.Keys;
import Entity.Enemy;
import Entity.Daiktai;
import Entity.zaidejas;
import Main.ZaidimoPanele;
import Manager.Content;
import Manager.GameStateManager;
//import Manager.Keys;
import tilemap.TileMap;

public class PlayState extends GameState {
	
	
	// tilemap
	private zaidejas zaidejas;
	
	private BufferedImage hudbg;
	
	private TileMap tileMap;
	
	private Font font;
	
	private ArrayList<Enemy> Priesai;
	
	// daiktai
	private ArrayList<Daiktai> Irankiai;
	
	//zaidejai
	private ArrayList<zaidejas> zaidejai;
	
	// camera position
	private int xsector;
	private int ysector;
	private int sectorSize; 
	
	private int z = 0; 
	
	
	
		

	
	// transition box
	private ArrayList<Rectangle> boxes;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		
		font = new Font(
				"Century Gothic",
				Font.PLAIN,
				16);
	}
	
	public void init() {
		
		hudbg = Content.HUDBG[0][0];
		
		Irankiai = new ArrayList<Daiktai>();
		zaidejai = new ArrayList<zaidejas>();
		Priesai = new ArrayList<Enemy>();
		
		// load map
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/tileset2.gif");
		tileMap.loadMap("/Maps/testmap.map");
			
			
		// fill lists	
		populateItems();
		
		populateEnemies();
		
		populatezaidejai();
		
        zaidejas = zaidejai.get(0);
				
		// set up camera position
		sectorSize = ZaidimoPanele.WIDTH;
		xsector = zaidejas.getx() / sectorSize;
		ysector = zaidejas.gety() / sectorSize;
		tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
		
		
		// start event
		boxes = new ArrayList<Rectangle>();
	
	}
	
	
private void populatezaidejai(){
	
	zaidejas Zaidejas;
	
	Zaidejas = new zaidejas(tileMap);
	Zaidejas.setTilePosition(10, 18);
	zaidejai.add(Zaidejas);
	
	Zaidejas = new zaidejas(tileMap);
	Zaidejas.setTilePosition(2, 2);
	zaidejai.add(Zaidejas);
	
	Zaidejas = new zaidejas(tileMap);
	Zaidejas.setTilePosition(18, 3);
	zaidejai.add(Zaidejas);
	
		
	}
private void populateEnemies(){
	
	Enemy enemy;
	
	enemy = new Enemy(tileMap);
	enemy.setType(Enemy.WOLF);
	//Initialize wolf
	enemy.setTilePosition(10, 10);
	Priesai.add(enemy);
}
	
private void populateItems() {
		
		Daiktai daiktai;
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.AXE);
		daiktai.setTilePosition(18, 10);
		Irankiai.add(daiktai);
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.BOW);
		daiktai.setTilePosition(8, 2);
		Irankiai.add(daiktai);
		
	}
	
	
	public void update() {
		
		// check keys
		handleInput();
		

		
		// update camera

		//int oldxs = xsector;
		//int oldys = ysector;
		xsector = zaidejas.getx() / sectorSize;
		ysector = zaidejas.gety() / sectorSize;
		tileMap.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tileMap.update();
		
		
		if(tileMap.isMoving()) return;
		
		for(zaidejas i : zaidejai) {
			i.update();
		}
		
	
	// update items
			for(int i = 0; i < Irankiai.size(); i++) {
				Daiktai daiktai = Irankiai.get(i);
				if(zaidejas.intersects(daiktai)) {
					Irankiai.remove(i);
					i--;
					daiktai.collected(zaidejas);
				}
			}
}
	
	public void draw(Graphics2D g) {
		
		// draw tilemap
		tileMap.draw(g);

		
		for(zaidejas i : zaidejai) {
			i.draw(g);
		}
		

		g.drawImage(hudbg, 600, 0, null);
		
		g.setFont(font);
		
		for(int i = 0; i < zaidejai.size(); i++) {
			String a = String.format("%02d", (zaidejai.get(i).getEjimai()));
	//		String a = String.valueOf(zaidejai.get(i).getEjimai());
			g.drawString(i+1 + " character: ", 620, 25+i*25);
			g.drawString(a, 725, 25+i*25);
			g.drawString("moves left.", 750, 25+i*25);
		}
		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		for(int i = 0; i < boxes.size(); i++) {
			g.fill(boxes.get(i));
		}
		
		// draw items
		for(Daiktai i : Irankiai) {
			i.draw(g);
		}
		
		for(Enemy i : Priesai) {
			i.draw(g);
		}
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if(Keys.isPressed(Keys.k)){
			
			if( z < zaidejai.size()){
				zaidejas = zaidejai.get(z);
				z++;
			}
			else {
				z = 0;
			}
		}
		if(Keys.isPressed(Keys.r)){
			
			for(zaidejas i : zaidejai) {
				i.reset();
			}
		}
		if(Keys.isPressed(Keys.LEFT))zaidejas.setLeft();
		if(Keys.isPressed(Keys.RIGHT))zaidejas.setRight();
		if(Keys.isPressed(Keys.UP))zaidejas.setUp();
		if(Keys.isPressed(Keys.DOWN))zaidejas.setDown();


		
		
	}

	
}
