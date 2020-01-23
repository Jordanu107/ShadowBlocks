import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.lwjgl.Sys;
import org.newdawn.slick.SlickException;

public class Loader {
	public static int xCoord;
	public static int yCoord;

	public static boolean isBlocked(float x, float y, int direction, ArrayList<Sprite> sprites) {
		for (Sprite sprite : sprites) {
			// Found the sprite that is currently in that position
			if (sprite.getX() == x && sprite.getY() == y) {
				switch (sprite.getType()) {
					case "res/wall.png":
						System.out.println("Wall");
						return true;
					case "res/stone.png":
						System.out.println("Stone");
						return ((Moveable) sprite).move(direction) == 0;
					default:
						System.out.println("Unsure");

				}
			}
		}
		return false;
	}
		
	/**
	 * Loads the sprites from a given file.
	 * @param filename - the location of the file that contains the sprite info
	 * @return spriteArray - an array of sprites
	 */
	public static ArrayList<Sprite> loadSprites(String filename) {
		ArrayList<Sprite> spriteArray = new ArrayList<>();
		try (BufferedReader br =
			    new BufferedReader(new FileReader(filename))) {
			
			// Find dimensions of the map in the file
			String[] dimensions = br.readLine().split(",");
			xCoord = Integer.parseInt(dimensions[0]);
			yCoord = Integer.parseInt(dimensions[1]);
			
			// Iterate through file, creating every Sprite in the file
			String text;
			while ((text = br.readLine()) != null) {
					String[] sprites = text.split(",");
					spriteArray.add(createSprite(sprites[0],
							Integer.parseInt(sprites[1]),
							Integer.parseInt(sprites[2])));
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		return spriteArray;
	}
	
	/**
	 * Creates a sprite given it's coordinates and type
	 * @param spriteType - What the sprite is
	 * @param x - x-coordinate of sprite
	 * @param y - y-coordinate of sprite
	 * @return - Sprite
	 * @throws SlickException - invalid sprite
	 */
	public static Sprite createSprite(String spriteType, int x, int y) throws SlickException {
		switch (spriteType) {
			case "wall":
				return new Wall("res/wall.png", x, y);
			case "player":
				return new Player("res/player_left.png", x, y);
			case "stone":
				return new Stone("res/stone.png", x, y);
			case "target":
				return new Target("res/target.png", x, y);
			case "floor":
				return new Floor("res/floor.png", x, y);
			case "cracked":
				return new CrackedWall("res/cracked_wall.png", x, y);
			case "tnt":
				return new TNT("res/tnt.png", x, y);
			case "ice":
				return new Ice("res/ice.png", x, y);
			case "switch":
				return new Switch("res/switch.png", x, y);
			case "door":
				return new Door("res/door.png", x, y);
			case "rogue":
				return new Rogue("res/rogue.png", x, y);
			case "mage":
				return new Mage("res/mage.png", x, y);
			case "skeleton":
				return new Skeleton("res/skull.png", x, y);
		}
		return null;
	}
}
