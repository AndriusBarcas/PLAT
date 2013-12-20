package GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.Random;




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
	private zaidejas t;
//	private zaidejas b;
	
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
	
	private int lygis = 1;
	
	private int z = 1; 
	
	private int suma;
	private int ejimai1;
	private int ejimai2;
	private int ejimai3;
	
	Random generator = new Random();
	
		

	
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
		if (lygis == 1){
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/tileset2.gif");
		tileMap.loadMap("/Maps/lygis1.map");
		}
		
		if (lygis == 2){
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/tileset2.gif");
		tileMap.loadMap("/Maps/Lygis_2.map");
		}
		
		if (lygis == 3){
			tileMap = new TileMap(30);
			tileMap.loadTiles("/Tilesets/tileset2.gif");
			tileMap.loadMap("/Maps/Lygis_3.map");
			}
			
		// fill lists	
		populateItems(lygis);
		
		populateEnemies(lygis);
		
		populatezaidejai();
		
		if (lygis == 1){
		for(zaidejas i : zaidejai) {
			int roll = generator.nextInt(8) + 10;
			i.setEjimai(roll);
		}
		}
		else{
			zaidejai.get(0).setEjimai(ejimai1);
			zaidejai.get(1).setEjimai(ejimai2);
			zaidejai.get(2).setEjimai(ejimai3);
		}
		
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
	Zaidejas.setTilePosition(1, 1);
	zaidejai.add(Zaidejas);
	
	Zaidejas = new zaidejas(tileMap);
	Zaidejas.setTilePosition(1, 2);
	zaidejai.add(Zaidejas);
	
	Zaidejas = new zaidejas(tileMap);
	Zaidejas.setTilePosition(1, 3);
	zaidejai.add(Zaidejas);
	
		
	}

private void populateEnemies(int lygis){
	
	Enemy enemy;
	if (lygis == 1){
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(5, 10);
		Priesai.add(enemy);
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(15, 7);
		Priesai.add(enemy);
	}
	if (lygis == 2){
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(5, 2);
		Priesai.add(enemy);
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(16, 13);
		Priesai.add(enemy);
	}
	if (lygis == 3){
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(10, 1);
		Priesai.add(enemy);
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(10, 6);
		Priesai.add(enemy);
		enemy = new Enemy(tileMap);
		enemy.setType(Enemy.WOLF);
		enemy.setTilePosition(10, 11);
		Priesai.add(enemy);
	}
}
	
private void populateItems(int lygis) {
		
		Daiktai daiktai;
		
		if(lygis == 1){
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.BOOTS);
		daiktai.setTilePosition(8, 10);
		Irankiai.add(daiktai);
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.POTION);
		daiktai.setTilePosition(12, 4);
		Irankiai.add(daiktai);
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.POTION);
		daiktai.setTilePosition(14, 15);
		Irankiai.add(daiktai);
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.BOOTS);
		daiktai.setTilePosition(4, 4);
		Irankiai.add(daiktai);
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.WINGS);
		daiktai.setTilePosition(2, 17);
		Irankiai.add(daiktai);
		
		daiktai = new Daiktai(tileMap);
		daiktai.setType(Daiktai.CROWN);
		daiktai.setTilePosition(18, 18);
		Irankiai.add(daiktai);
		}
		
		if(lygis == 2){
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(8, 10);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(4, 18);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(6, 11);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(3,3);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(12, 4);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(3, 6);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(12, 17);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(1, 10);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.WINGS);
			daiktai.setTilePosition(18, 10);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(14, 15);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.WINGS);
			daiktai.setTilePosition(7, 2);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.CROWN);
			daiktai.setTilePosition(18, 18);
			Irankiai.add(daiktai);
		}
		if(lygis == 3){
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.WINGS);
			daiktai.setTilePosition(8, 3);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(9, 9);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(13,13);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(3, 7);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(2, 18);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(7,18);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(15, 5);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.BOOTS);
			daiktai.setTilePosition(4, 15);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.POTION);
			daiktai.setTilePosition(18, 9);
			Irankiai.add(daiktai);
			
			daiktai = new Daiktai(tileMap);
			daiktai.setType(Daiktai.CROWN);
			daiktai.setTilePosition(18, 18);
			Irankiai.add(daiktai);
		}
	}

public int objectup(){
	int o = 0;
    t = zaidejas;
	for(zaidejas i : zaidejai) {
		if (i.getCol() == t.getCol() && i.getRow() + 1 == t.getRow()){
			o = 1; 
		}
	}
	for(Enemy e : Priesai) {
		if (e.getx() == t.getx() && e.gety() + 30 == t.gety()){
			o = 2; 	
		}
	}
	return o;
	}

public int objectdown(){
	int o = 0;
	 t = zaidejas;
	for(zaidejas i : zaidejai) {
		if (i.getCol() == t.getCol() && i.getRow() - 1 == t.getRow()){
			o = 1; 
		}
	}
	for(Enemy e : Priesai) {
		if (e.getx() == t.getx() && e.gety() - 30 == t.gety()){
			o = 2; 	
		}
	}
	return o;
	}	

public int objectleft(){
	int o = 0;
	 t = zaidejas;
	for(zaidejas i : zaidejai) {
		if (i.getx() + 30 == t.getx() && i.getRow()== t.getRow()){
			o = 1; 
		}
	}
	for(Enemy e : Priesai) {
		if (e.getx() + 30 == t.getx() && e.gety()== t.gety()){
			o = 2; 	
		}
	}
	return o;
	}

public int objectright(){
	int o = 0;
	 t = zaidejas;
	for(zaidejas i : zaidejai) {
		if (i.getCol() - 1 == t.getCol() && i.getRow()== t.getRow()){
			o = 1; 
		}
	}
	for(Enemy e : Priesai) {
		if (e.getx() - 30 == t.getx() && e.gety()== t.gety()){
			o = 2; 	
		}
	}
	return o;
	}

public void tikrinimas(){
	t = zaidejas;
	for(Enemy e : Priesai) {
		if (e.getx()  == t.getx() && e.gety() == t.gety()){
			zaidejas.setEjimai(0);	
		}
	}
}

	
	public void update() {
		
		suma = 0;
		// check keys
		handleInput();
		
		tikrinimas();
		
		if (suma == 0)
			gsm.setState(GameStateManager.GAMEOVER);
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
			for(Enemy i : Priesai) {
				i.update();
				i.enemymove();
			}
	
	// update items
			int checka = 0;
			for(int i = 0; i < Irankiai.size(); i++) {
				Daiktai daiktai = Irankiai.get(i);
				if(zaidejas.intersects(daiktai)) {
					Irankiai.remove(i);
					i--;
					checka = daiktai.collected(gsm, zaidejas, lygis);
					if (checka != lygis){
						ejimai1 = zaidejai.get(0).getEjimai();
						ejimai2 = zaidejai.get(1).getEjimai();
						ejimai3 = zaidejai.get(2).getEjimai();
						lygis = checka;
						init();
					}
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
		g.drawString("Help:",620, 550);
		g.drawString("Swap Character:   K",620, 580);

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
		if(Keys.isPressed(Keys.LEFT)&& objectleft() == 0){
			zaidejas.setLeft();
			
		}
		if(Keys.isPressed(Keys.RIGHT)&& objectright() == 0){
			zaidejas.setRight();
		}
		if(Keys.isPressed(Keys.UP)&& objectup() == 0){
			zaidejas.setUp();
		}
		if(Keys.isPressed(Keys.DOWN)&& objectdown() == 0){
			zaidejas.setDown();
		}


		
		
	}

	
}

