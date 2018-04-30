import java.io.BufferedReader;
import java.io.FileReader;

public class Loader {	
	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	public static boolean isBlocked(float x, float y) {
		// Default to blocked
		return true;
	}
		
	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return
	 */
	public static Sprite[] loadSprites(String filename) {
		
		return null;
	}
	
	/**
	 * Counts the number of sprites in a given file.
	 * @param filename
	 * @return
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
