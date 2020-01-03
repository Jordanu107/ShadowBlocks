import org.newdawn.slick.SlickException;

public class Moveable extends Sprite {
    public Moveable(String image_src, int x, int y) throws SlickException {
        super(image_src, x, y);
    }

    /**
     * Change the location of the moveable sprite given a direction
     * @param direction - direction of motion
     */
    public int move(int direction) {
        int hasMoved = 0;
        switch (direction) {
            case 0:
                if(!Loader.isBlocked(this.getX(), this.getY() - 1, direction, World.getAllSprites())) {
                    setY(this.getY() - 1);
                    hasMoved = 1;
                }
                return hasMoved;
            case 1:
                if(!Loader.isBlocked(this.getX(), this.getY() + 1, direction, World.getAllSprites())) {
                    setY(this.getY() + 1);
                    hasMoved = 1;
                }
                return hasMoved;
            case 2:
                if(!Loader.isBlocked(this.getX() - 1, this.getY(), direction, World.getAllSprites())) {
                    setX(this.getX() - 1);
                    hasMoved = 1;
                }
                return hasMoved;
            case 3:
                if(!Loader.isBlocked(this.getX() + 1, this.getY(), direction, World.getAllSprites())) {
                    setX(this.getX() + 1);
                    hasMoved = 1;
                }
                return hasMoved;
            default:
                return hasMoved;
        }
    }
}
