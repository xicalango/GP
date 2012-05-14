package gp;

public class GP03A05 {

	
	public static int det( int x1, int y1, int x2, int y2, int x3, int y3 ) {
		return (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
	}
	
	public static boolean liegt_innerhalb( int x1, int y1, int x2, int y2, int x3, int y3, int p_x, int p_y ) {
		
		if( det(p_x, p_y, x1, y1, x2, y2) < 0 )
			return false;

		if( det(p_x, p_y, x2, y2, x3, y3) < 0 )
			return false;

		if( det(p_x, p_y, x3, y3, x1, y1) < 0 )
			return false;

		return true;
		
	}
	
	public static boolean liegt_innerhalb( int p_x, int p_y ) {
		return liegt_innerhalb(4, 1, -3, 2, 6, -5, p_x, p_y);
	}
	
	public static void main(String[] args) {
	
		if(args.length == 2) {
			System.out.println( liegt_innerhalb(Integer.parseInt(args[0]), Integer.parseInt(args[1])) );
		} else if(args.length == 8) {
			System.out.println( liegt_innerhalb(
					Integer.parseInt(args[0]),
					Integer.parseInt(args[1]),
					Integer.parseInt(args[2]),
					Integer.parseInt(args[3]),
					Integer.parseInt(args[4]),
					Integer.parseInt(args[5]),
					Integer.parseInt(args[6]),
					Integer.parseInt(args[7])
					) );
		} else {
			System.out.println("Falsche Anzahl an Parameter. Entweder 2 oder 8 Parameter sind erlaubt.");
		}
		
	}
	
}
