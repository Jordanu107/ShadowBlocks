import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	int spriteCount = Loader.countSprites("res/levels/0.lvl");
	Sprite[] spriteArray = new Sprite[spriteCount];
	
	// Offset coordinates to achieve a centred map
	float offsetX;
	float offsetY;
	
	public World() throws SlickException {
		spriteArray = Loader.loadSprites("res/levels/0.lvl");
		
		offsetX = (float) (App.SCREEN_WIDTH / 2.0 - (Loader.xCoord / 2.0) * App.TILE_SIZE);
		offsetY = (float) (App.SCREEN_HEIGHT / 2.0 - (Loader.yCoord / 2.0) * App.TILE_SIZE);
	}
	
	public void update(Input input, int delta) {
	}
	
	public void render(Graphics g) {
		for (int i=0; i<spriteCount; i++) {
			g.drawImage(spriteArray[i].getImage(),
					spriteArray[i].getX() * App.TILE_SIZE + offsetX,
					spriteArray[i].getY() * App.TILE_SIZE + offsetY);
		}
	}
}
