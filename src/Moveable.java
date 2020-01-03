import org.newdawn.slick.SlickException;

public class Moveable extends Sprite {
    public Moveable(String image_src, int x, int y) throws SlickException {
        super(image_src, x, y);
    }

    /**
     * Change the location of the moveable sprite given a direction
     * @param direction - direction of motion
     */
    public void move(int direction) {
        switch (direction) {
            case 0:
                if(!Loader.isBlocked(this.getX(), this.getY() - 1, World.getAllSprites())) {
                    setY(this.getY() - 1);
                }
                break;
            case 1:
                if(!Loader.isBlocked(this.getX(), this.getY() + 1, World.getAllSprites())) {
                    setY(this.getY() + 1);
                }
                break;
            case 2:
                if(!Loader.isBlocked(this.getX() - 1, this.getY(), World.getAllSprites())) {
                    setX(this.getX() - 1);
                }
                break;
            case 3:
                if(!Loader.isBlocked(this.getX() + 1, this.getY(), World.getAllSprites())) {
                    setX(this.getX() + 1);
                }
                break;
        }
    }
}
