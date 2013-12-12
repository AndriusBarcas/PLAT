package Manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Manager.Content;

public class Content {
	
	public static BufferedImage[][] MENUBG = load("/HUD/menuscreen.jpg", 850, 600);
	public static BufferedImage[][] MARKER = load("/HUD/marker.gif", 25, 25);
	public static BufferedImage[][] HUDBG = load("/HUD/hudbg.gif", 250, 600);
	public static BufferedImage[][] END = load("/HUD/end.jpg", 850, 600);
	public static BufferedImage[][] GAMEOVER = load("/HUD/game_over.jpg", 850, 600);
	
	public static BufferedImage[][] zaidejas = load("/Spraitai/zaidejospraitai.gif", 30, 30);
	
	//Vilko spraitai
	public static BufferedImage[][] ENEMY = load("/Spraitai/wolf2.gif", 30, 30);
	public static BufferedImage[][] FIRE = load("/Spraitai/Fire.gif", 30, 30);
	
	public static BufferedImage[][] DAIKTAI = load("/Spraitai/items.gif", 30, 30);
	//public static BufferedImage[][] font = load("/HUD/font.gif", 8, 8);
	
	
	public static BufferedImage[][] load(String s, int w, int h) {
		BufferedImage[][] ret;
		try {
			BufferedImage spritesheet = ImageIO.read(Content.class.getResourceAsStream(s));
			int width = spritesheet.getWidth() / w;
			int height = spritesheet.getHeight() / h;
			ret = new BufferedImage[height][width];
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
				}
			}
			return ret;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error loading graphics.");
			System.exit(0);
		}
		return null;
	}
	
	public static void drawString(Graphics2D g, String s, int x, int y) {
		s = s.toUpperCase();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == 47) c = 36; // slash
			if(c == 58) c = 37; // colon
			if(c == 32) c = 38; // space
			if(c >= 65 && c <= 90) c -= 65; // letters
			if(c >= 48 && c <= 57) c -= 22; // numbers
			//int row = c / font[0].length;
			//int col = c % font[0].length;
			//g.drawImage(font[row][col], x + 8 * i, y, null);
		}
	}
}
