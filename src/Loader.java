import java.io.BufferedReader;
import java.io.FileReader;

import org.newdawn.slick.SlickException;

public class Loader {
	public static int xCoord;
	public static int yCoord;
	
	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	public static boolean isBlocked(float x, float y, Sprite[] sprites) {
		for (int i=0; i<World.spriteCount; i++) {
			if (sprites[i].getX() == x && sprites[i].getY() == y &&
					sprites[i].getType().equals("res/wall.png")) {
				return true;
			}
		}
		return false;
	}
		
	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return spriteArray
	 */
	public static Sprite[] loadSprites(String filename) {
		Sprite[] spriteArray = new Sprite[countSprites(filename)];
		try (BufferedReader br =
			    new BufferedReader(new FileReader(filename))) {
			
			// Find dimensions of the map in the file
			String[] dimensions = br.readLine().split(",");
			xCoord = Integer.parseInt(dimensions[0]);
			yCoord = Integer.parseInt(dimensions[1]);
			
			// Iterate through file, creating every Sprite in the file
			String text;
			int count = 0;
			while ((text = br.readLine()) != null && count < spriteArray.length) {
					String[] sprites = text.split(",");
					spriteArray[count] = createSprite(sprites[0],
							Integer.parseInt(sprites[1]),
							Integer.parseInt(sprites[2]));
					count++;
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		return spriteArray;
	}
	
	/**
	 * Creates a sprite given it's coordinates and type
	 * @param spriteType
	 * @param x
	 * @param y
	 * @return
	 * @throws SlickException 
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
		}
		return null;
	}
	
	/**
	 * Counts the number of sprites in a given file.
	 * @param filename
	 * @return count
	 */
	public static int countSprites(String filename) {
		int count = 0;
		try (BufferedReader br =
			    new BufferedReader(new FileReader(filename))) {
			String text;
			// Iterate through file, counting every sprite
			while ((text = br.readLine()) != null) {
					String[] split = text.split(",");
					if (split.length == 3) {
						count++;
					}
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		return count;
	}
}
