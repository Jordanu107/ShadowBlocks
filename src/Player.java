import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {

	public Player(String image_src, int x, int y) throws SlickException {
		super(image_src, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(Input input, int delta) {
		if (input.isKeyPressed(input.KEY_UP)) {
			move(0);
		}
		if (input.isKeyPressed(input.KEY_DOWN)) {
			move(1);
		}
		if (input.isKeyPressed(input.KEY_LEFT)) {
			move(2);
		}
		if (input.isKeyPressed(input.KEY_RIGHT)) {
			move(3);
		}
	}
}
