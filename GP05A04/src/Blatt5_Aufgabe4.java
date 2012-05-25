import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
			return o1[p.pos] - o2[p.pos];
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
	
	public static boolean in_bounding_box(int[][] bounding_box, int x, int y) {
		return x >= bounding_box[0][0] && x <= bounding_box[1][0] && y >= bounding_box[0][1] && y <= bounding_box[1][1];
	}

	public static void ppp(int[][] polygon) {
		for( int[] p : polygon ) {
			System.out.print("(" + p[0] + ", " + p[1] + ") ");
		}
		System.out.println();
	}
	
	public static boolean liegt_innerhalb(int[][] polygon, int x_a, int y_a) {
		// TODO: Spezifikation des �bungsblattes implementieren
		
		
		int[] inters = getSortedIntersections(polygon, get_bounding_box(polygon), y_a);
		
		for( int i = 0; i < inters.length-1; i++ ) {
			
			System.out.println(inters[i]+","+x_a+","+inters[i+1]);
			
			if( x_a >= inters[i] && x_a <= inters[i+1]) {
				return (i%2) == 0;
			}
		}
		
		
		
		return false;
	}
	
	public static <T> T getArrayRing(T[] array, int ix) {
		return array[ix % array.length];
	}
	
	public static boolean point_on_line(int x1, int y1, int x2, int y2, int xp, int yp) {
		return (xp - x1) * (y2 - y1) - (yp - y1)*(x2 - x1) == 0 && (xp-x1)*(xp-x2) <= 0 ;
	}
	
	public static int[] getSortedIntersections(int[][] polygon, int[][] bounding_box, int y) {
		
		SortedSet<Integer> intersList = new TreeSet<Integer>();
		
		final int nPoints = polygon.length;
		
		for( int i = 0; i < nPoints; i++ ) {
			final int[] p1 = polygon[i % nPoints];
			final int[] p2 = polygon[(i+1) % nPoints];
			
			System.out.println(i+"-"+(i+1)%nPoints+":"+Arrays.toString(p1)+"-"+Arrays.toString(p2));
			
			if(p1[1] == p2[1]) //gleiche y-Koordinaten => ignorieren
				continue;
			
			final int nom = (y - p1[1]) * (p2[0] - p1[0]);
			final int xs = p1[0] + nom/(p2[1] - p1[1]);
			
			if(in_bounding_box(bounding_box, xs, y) && point_on_line(p1[0], p1[1], p2[0], p2[1], xs, y))
			{
				System.out.println(xs + " Taken");
				intersList.add(xs);
			} else {
				System.out.println(xs + " Rejected");
			}
		}
		
		int[] inters = new int[intersList.size()];
		int i = 0;
		
		for( int is : intersList ) {
			inters[i++] = is;
		}
		
		return inters;
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