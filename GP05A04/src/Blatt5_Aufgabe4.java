import java.io.*;


/************************************************************
Skeleton f�r Blatt_5/Aufgabe_4
************************************************************/

public class Blatt5_Aufgabe4 {

  public static boolean liegt_innerhalb(int [][] polygon, int x_a, int y_a){
    //TODO: Spezifikation des �bungsblattes implementieren
    return true;
  }

  public static void main(String[] args) {
     String Eingabe = "";
     BufferedReader in;
     int [][] polygon = new int [0][0];
     int x_a = 0;
     int y_a = 0;
     boolean done = false;
     while (true){
          try{
            in = new BufferedReader(new InputStreamReader(System.in));
            Eingabe = in.readLine();
            done = Eingabe.equals(new String("q"));
          }
          catch (Exception e){}
          if (done) break;
          //TODO: Polygonpunkte sowie x_a und y_a aus der Eingabe extrahieren
          //Beispiel: Bei Eingabe von
          //4 3 -4 1 5 -2 12 -4
          //soll getestet werden, ob der Punkt (12, -4) innerhalb des von
          //(4, 3), (-4, 1) und (5, -2) (in dieser Reihenfolge) aufgespannten
          //Polygons liegt.
          System.out.println(liegt_innerhalb(polygon, x_a, y_a));
     }
  }
}