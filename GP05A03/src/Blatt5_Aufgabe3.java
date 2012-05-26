import java.io.*;
import java.util.logging.Logger;

/************************************************************
 * Skeleton f�r Blatt_5/Aufgabe_3
 ************************************************************/

public class Blatt5_Aufgabe3 {

	public static int det(int x_a, int y_a, int x_b, int y_b, int x_c, int y_c, int x_d, int y_d) {
		return (x_b - x_a) * (y_d - y_c) - (x_d - x_c) * (y_b - y_a);
	}

	public static int intersects(int x_a, int y_a, int x_b, int y_b, int x_c, int y_c, int x_d, int y_d) {
		final int N = det(x_a, y_a, x_b, y_b, x_c, y_c, x_d, y_d);

		//System.out.println("N: " + N);

		final int Ns = (x_d - x_c) * (y_a - y_c) - (y_d - y_c) * (x_a - x_c);
		final int Nt = (x_b - x_a) * (y_a - y_c) - (y_b - y_a) * (x_a - x_c);

		//System.out.println("Ns: " + Ns);
		//System.out.println("Nt: " + Nt);
		
		if (N == 0 && Ns == 0 && Nt == 0) {
			return 2;
		} else if (N == 0) {
			return 0;
		}

		final int N_sq = N * N;
		final int Ns_N = Ns * N;
		final int Nt_N = Nt * N;

		if (Ns_N >= 0 && Ns_N <= N_sq && Nt_N >= 0 && Nt_N <= N_sq)
			return 1;

		return 0;
	}

	public static void main(String[] args) {
		String Eingabe = "";
		BufferedReader in;
		int x_a = 0;
		int y_a = 0;
		int x_b = 0;
		int y_b = 0;
		int x_c = 0;
		int y_c = 0;
		int x_d = 0;
		int y_d = 0;
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

			String[] EingabeSplit = Eingabe.trim().split(" ");
			try {
				x_a = Integer.parseInt(EingabeSplit[0]);
				y_a = Integer.parseInt(EingabeSplit[1]);
				x_b = Integer.parseInt(EingabeSplit[2]);
				y_b = Integer.parseInt(EingabeSplit[3]);
				x_c = Integer.parseInt(EingabeSplit[4]);
				y_c = Integer.parseInt(EingabeSplit[5]);
				x_d = Integer.parseInt(EingabeSplit[6]);
				y_d = Integer.parseInt(EingabeSplit[7]);

				// TODO: x_a, y_a, x_b, y_b, x_c, y_c, x_d und y_d aus der
				// Eingabe
				// extrahieren
				// Beipiel: Bei Eingabe von
				// 3 2 5 3 -1 -2 7 -9
				// soll ermittelt werden, in wie vielen Punkten sich die Strecke
				// von
				// (3,2) nach (5,3)
				// und die Strecke von (-1, -2) nach (7, -9) schneiden.
				System.out.println(intersects(x_a, y_a, x_b, y_b, x_c, y_c, x_d, y_d));
			} catch (NumberFormatException nfe) {
				System.out.println("Unbekannte Eingabe: " + nfe.getMessage());
			}
		}
	}
}