import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.awt.*;
import java.util.ArrayList;

public class World {
	private static int levelNumber = 0;
	private static ArrayList<Sprite> spriteArray = new ArrayList<>();
	private ArrayList<Point> targets = new ArrayList<>();
	private float offsetX;
	private float offsetY;
	
	public World() throws SlickException {
		regenerateWorld();
	}
	
	public void update(Input input, int delta) {
		if (isLevelComplete(getAllSprites(), targets)) {
			levelNumber++;
			regenerateWorld();
		}
		for (Sprite sprite: spriteArray) {
			sprite.update(input, delta);
		}

		if (input.isKeyPressed(input.KEY_R)) {
			regenerateWorld();
		} else if (input.isKeyPressed(input.KEY_Q)) {
			System.exit(0);
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

	/**
	 * Generates a world with the current level and creates the required sprites
	 */
	public void regenerateWorld() {
		spriteArray = Loader.loadSprites("res/levels/" + levelNumber + ".lvl");
		targets = Loader.findTargets(getAllSprites());
		offsetX = (float) (App.SCREEN_WIDTH / 2.0 - (Loader.xCoord / 2.0) * App.TILE_SIZE);
		offsetY = (float) (App.SCREEN_HEIGHT / 2.0 - (Loader.yCoord / 2.0) * App.TILE_SIZE);
	}

	public boolean isLevelComplete(ArrayList<Sprite> spriteArray, ArrayList<Point> targets) {
		for (Sprite sprite : spriteArray) {
			if (sprite.getType().equals("res/stone.png") || sprite.getType().equals("res/ice.png")) {
				Point spriteLocation = new Point((int) sprite.getX(), (int) sprite.getY());
				if (!targets.contains(spriteLocation)) {
					return false;
				}
			}
		}
		return true;
	}
}
