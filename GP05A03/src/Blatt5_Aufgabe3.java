import java.io.*;


/************************************************************
Skeleton f�r Blatt_5/Aufgabe_3
************************************************************/

public class Blatt5_Aufgabe3 {

  public static int intersects(int x_a, int y_a, int x_b, int y_b, int x_c, int y_c, int x_d, int y_d){
    //TODO: Spezifikation des �bungsblattes implementieren
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
     while (true){
          try{
            in = new BufferedReader(new InputStreamReader(System.in));
            Eingabe = in.readLine();
            done = Eingabe.equals(new String("q"));
          }
          catch (Exception e){}
          if (done) break;
          //TODO: x_a, y_a, x_b, y_b, x_c, y_c, x_d und y_d aus der Eingabe extrahieren
          //Beipiel: Bei Eingabe von
          //3 2 5 3 -1 -2 7 -9
          //soll ermittelt werden, in wie vielen Punkten sich die Strecke von (3,2) nach (5,3)
          //und die Strecke von (-1, -2) nach (7, -9) schneiden.
          System.out.println(intersects(x_a, y_a, x_b, y_b, x_c, y_c, x_d, y_d));
     }
  }
}