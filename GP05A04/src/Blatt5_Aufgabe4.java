import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/************************************************************
 * Skeleton f�r Blatt_5/Aufgabe_4
 ************************************************************/

public class Blatt5_Aufgabe4 {

	private static class PointComparator implements Comparator<int[]> {
		
		public static enum Pos {
			X(0),
			Y(1);
			
			private int pos;

			private Pos(int pos) {
				this.pos = pos;
			}
		}
		
		private Pos p = Pos.X;

		public PointComparator(Pos p) {
			super();
			this.p = p;
		}

		public PointComparator() {
		}

		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[p.pos] - o1[p.pos];
		}
	}
	
	public static int[][] get_bounding_box(int[][] polygon) {
		int[][] result = new int[2][2];
		
		result[0][0] = polygon[0][0];
		result[0][1] = polygon[0][1];
		result[1][0] = polygon[0][0];
		result[1][1] = polygon[0][1];
		
		for( int i = 1; i < polygon.length; i++ ) {
			
			if( polygon[i][0] < result[0][0] )
				result[0][0] = polygon[i][0];
			
			if( polygon[i][1] < result[0][1] )
				result[0][1] = polygon[i][1];
			
			if( polygon[i][0] > result[1][0] )
				result[1][0] = polygon[i][0];
			
			if( polygon[i][1] > result[1][1] )
				result[1][1] = polygon[i][1];
		}
		
		return result;
	}

	public static void ppp(int[][] polygon) {
		for( int[] p : polygon ) {
			System.out.print("(" + p[0] + ", " + p[1] + ") ");
		}
		System.out.println();
	}
	
	public static boolean liegt_innerhalb(int[][] polygon, int x_a, int y_a) {
		// TODO: Spezifikation des �bungsblattes implementieren
		
		ppp(get_bounding_box(polygon));
		
		return true;
	}
	
	public static int[][] getSortedIntersections(int[][] polygon, int[][] bounding_box, int y) {
		
		SortedSet<int[]> res = new TreeSet<int[]>(new PointComparator());
		
		int[][] gerade = {
				{bounding_box[0][0],y},
				{bounding_box[1][0],y}
		};
		
		return res.toArray(new int[0][]);
		
	}

	public static void main(String[] args) {
		String Eingabe = "";
		BufferedReader in;
		int[][] polygon = new int[0][0];
		int x_a = 0;
		int y_a = 0;
		boolean done = false;
		while (true) {
			try {
				in = new BufferedReader(new InputStreamReader(System.in));
				Eingabe = in.readLine();
				done = Eingabe.equals(new String("q"));
			} catch (Exception e) {
			}
			if (done)
				break;
			
			String[] EingabeSplit = Eingabe.split(" ");
			List<int[]> polypoints = new ArrayList<int[]>();
			
			int i = 0;
			for(; i < EingabeSplit.length-2; i+=2) {
				
				polypoints.add(new int[] {
						Integer.parseInt(EingabeSplit[i]),
						Integer.parseInt(EingabeSplit[i+1])
				});
				
			}
			
			polygon = polypoints.toArray(new int[0][]);
			
			x_a = Integer.parseInt(EingabeSplit[i]);
			y_a = Integer.parseInt(EingabeSplit[i+1]);
			
			
			// TODO: Polygonpunkte sowie x_a und y_a aus der Eingabe extrahieren
			// Beispiel: Bei Eingabe von
			// 4 3 -4 1 5 -2 12 -4
			// soll getestet werden, ob der Punkt (12, -4) innerhalb des von
			// (4, 3), (-4, 1) und (5, -2) (in dieser Reihenfolge) aufgespannten
			// Polygons liegt.
			System.out.println(liegt_innerhalb(polygon, x_a, y_a));
		}
	}
}