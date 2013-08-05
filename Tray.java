import java.util.*;
public class Tray {

	private ArrayList<Block> emptyspace = new ArrayList<Block>();
	
	public Tray (int length, int width){
		for (int x = 0; x < length; x ++) {
			for (int y = 0; y < width; y ++) {
				emptyspace.add(new Block(x, y, x, y));
			}
		}
	}
	
	public void add (Block b) {
		if (!contains(b)) {
			for (int x = b.getUL().x; x < b.getLR().x + 1; x ++ ) {
				for (int y = b.getUL().y; y < b.getLR().y + 1; y ++ ) {
					Block newblock = new Block(x, y, x, y);
					emptyspace.remove(newblock);
				}
			}
		} else {
			throw new IllegalStateException("can't add a block that already exists");
		}
	}
	
	
	public boolean contains (Block b) {
		if (!emptyspace.contains(b)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Tray x = new Tray(5,4);
	}
}
