import java.awt.Point;
import java.util.*;

public class Block {
	
	private Point upperleft;
	private Point lowerright;
	private ArrayList<Point> alreadyseen = new ArrayList();
	

	
	public Block(int ul1, int ul2, int lr1, int lr2) {
		upperleft = new Point(ul1, ul2);
		lowerright = new Point(lr1, lr2);
		if (!contains(upperleft) && !contains(lowerright)) {
			if (upperleft != lowerright) {
				alreadyseen.add(upperleft);
				alreadyseen.add(lowerright);
			} else {
				alreadyseen.add(upperleft);
			}
		} else {
			throw new IllegalStateException("invalid location for block");
		}
	}
	
	public boolean contains(Point p) {
		if (alreadyseen.contains(p)) {
			return true;
		}
		return false;
	}
	
	public Point getUL() {
		return upperleft;
	}
	
	public Point getLR() {
		return lowerright;
	}
	

	public void setLR(int x, int y) {
		Point newpoint = new Point(x, y);
		lowerright = newpoint;
	}
}
