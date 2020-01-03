import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	private static String filename = "res/levels/3.lvl";
	static int spriteCount = Loader.countSprites(filename);
	private static Sprite[] spriteArray = new Sprite[spriteCount];
	private float offsetX;
	private float offsetY;
	
	public World() throws SlickException {
		spriteArray = Loader.loadSprites(filename);
		
		// Offset coordinates to achieve a centered map
		offsetX = (float) (App.SCREEN_WIDTH / 2.0 - (Loader.xCoord / 2.0) * App.TILE_SIZE);
		offsetY = (float) (App.SCREEN_HEIGHT / 2.0 - (Loader.yCoord / 2.0) * App.TILE_SIZE);
	}
	
	public void update(Input input, int delta) {
		for (int i=0; i<spriteCount; i++) {
			spriteArray[i].update(input, delta);
		}
	}
	
	public void render(Graphics g) {
		for (int i=0; i<spriteCount; i++) {
			g.drawImage(spriteArray[i].getImage(),
					spriteArray[i].getX() * App.TILE_SIZE + offsetX,
					spriteArray[i].getY() * App.TILE_SIZE + offsetY);
		}
	}
	
	public static Sprite[] getAllSprites() {
		return spriteArray;
	}
}
