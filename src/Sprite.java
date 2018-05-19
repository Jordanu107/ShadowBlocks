import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Sprite {
	private float x;
	private float y;
	private String image_src;
	private Image image;
	public Sprite(String image_src, float x, float y) throws SlickException {
		this.image_src = image_src;
		this.x = x;
		this.y = y;
		this.image = new Image(image_src);
	}
	
	public void update(Input input, int delta) {
	}
	
	public void render(Graphics g) {
	}
	
	/**
	 * Change the location of the sprite give a direction
	 * @param direction
	 */
	public void move(int direction) {
		switch (direction) {
			case 0:
				if(!Loader.isBlocked(x, y-1, World.getAllSprites())) {
					y -= 1;
				}
				break;
			case 1:
				if(!Loader.isBlocked(x, y+1, World.getAllSprites())) {
					y += 1;
				}
				break;
			case 2:
				if(!Loader.isBlocked(x-1, y, World.getAllSprites())) {
					x -= 1;
				}
				break;
			case 3:
				if(!Loader.isBlocked(x+1, y, World.getAllSprites())) {
					x += 1;
				}
				break;
		}
	}
	
	// Shallow copy of x coordinate
	public float getX() {
		return new Float(x);
	}
	
	// Shallow copy of y coordinate
	public float getY() {
		return new Float(y);
	}
	
	// Deep copy of image
	public Image getImage() {
		return image;
	}
	
	public String getType() {
		return new String(image_src);
	}
}
