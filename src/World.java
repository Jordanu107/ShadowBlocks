import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {	
	Image img;
	public World() throws SlickException {
		img = new Image("res/floor.png");
		img.draw(100, 100);
	}
	
	public void update(Input input, int delta) {
	}
	
	public void render(Graphics g) {
		img.draw(100,100);
	}
}
