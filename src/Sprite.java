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
	
	// Shallow copy of x coordinate
	public float getX() {
		return new Float(x);
	}
	
	// Shallow copy of y coordinate
	public float getY() {
		return new Float(y);
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	// Deep copy of image
	public Image getImage() {
		return image;
	}
	
	public String getType() {
		return new String(image_src);
	}
}
