import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class World {
	private static int levelNumber = 0;
	private static String filename = "res/levels/" + levelNumber + ".lvl";
	private static ArrayList<Sprite> spriteArray = new ArrayList<>();
	private float offsetX;
	private float offsetY;
	
	public World() throws SlickException {
		spriteArray = Loader.loadSprites(filename);
		
		// Offset coordinates to achieve a centered map
		offsetX = (float) (App.SCREEN_WIDTH / 2.0 - (Loader.xCoord / 2.0) * App.TILE_SIZE);
		offsetY = (float) (App.SCREEN_HEIGHT / 2.0 - (Loader.yCoord / 2.0) * App.TILE_SIZE);
	}
	
	public void update(Input input, int delta) {
		for (Sprite sprite: spriteArray) {
			sprite.update(input, delta);
		}

		if (input.isKeyPressed(input.KEY_N)) {
			levelNumber++;
			filename = "res/levels/" + levelNumber + ".lvl";
			System.out.println(filename);
//			regenerateWorld(filename);
		}
	}
	
	public void render(Graphics g) {
		for (Sprite sprite : spriteArray) {
			g.drawImage(sprite.getImage(),
					sprite.getX() * App.TILE_SIZE + offsetX,
					sprite.getY() * App.TILE_SIZE + offsetY);
		}
	}
	
	public static ArrayList<Sprite> getAllSprites() {
		return spriteArray;
	}

//	public void regenerateWorld(String filename) {
//		World.filename = filename;
//		spriteCount = Loader.countSprites(filename);
//		spriteArray = new Sprite[spriteCount];
//		offsetX = (float) (App.SCREEN_WIDTH / 2.0 - (Loader.xCoord / 2.0) * App.TILE_SIZE);
//		offsetY = (float) (App.SCREEN_HEIGHT / 2.0 - (Loader.yCoord / 2.0) * App.TILE_SIZE);
//	}
}
