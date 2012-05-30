package gp.world;

public enum Direction {
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	private int bitmask;

	public int getBitmask() {
		return bitmask;
	}

	private Direction(int bit) {
		this.bitmask = 1 << bit;
	}
	
}
