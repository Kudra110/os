import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HomeWork1 {

  public static void main(String[] args)

      throws IOException

  {

    int Arrival_Time[] = new int[5];
    int Burst_Time[] = new int[5];
    int Waiting_Time[] = new int[5];
    int Turnaround_Time[] = new int[5];
    String Process_ID[] = { "P1", "P2", "P3", "P4", "P5" };
    String Process_State[] = new String[5];

    int[][] input = new int[2][5];

    int i = 0;

    try {
      File file = new File("C:\\Users\\AL-Amani\\OneDrive\\سطح المكتب\\VS\\test.csv");
      // BufferedReader reader = new BufferedReader(new FileReader(file));
      Scanner reader = new Scanner(file);
      // String str;

      while (reader.hasNextLine()) {

        String data[] = reader.nextLine().split(",");

        for (int j = 0; j < data.length; j++) {

          input[i][j] = Integer.valueOf(data[j]);

        }

        i++;

      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    for (int j = 0; j < input.length - 1; j++) {
      for (int j2 = 0; j2 < input[j].length; j2++) {
        Arrival_Time[j2] = input[j][j2];
      }
    }
    for (int j = 0; j < input.length; j++) {
      for (int j2 = 0; j2 < input[j].length; j2++) {
        Burst_Time[j2] = input[j][j2];
      }
    }

    // sort Arrival_Time array
    for (int j = 0; j < Arrival_Time.length; j++) {
      for (int j2 = j + 1; j2 < Arrival_Time.length; j2++) {
        int temp = 0;
        int temp2 = 0;
        String temp3;
        if (Arrival_Time[j] > Arrival_Time[j2]) {
          temp = Arrival_Time[j];
          Arrival_Time[j] = Arrival_Time[j2];
          Arrival_Time[j2] = temp;

          temp2 = Burst_Time[j];
          Burst_Time[j] = Burst_Time[j2];
          Burst_Time[j2] = temp2;

          temp3 = Process_ID[j];
          Process_ID[j] = Process_ID[j2];
          Process_ID[j2] = temp3;
        }
      }
    }

    int CpuTime = 0;

    System.out.println();
    System.out.print("Waiting_Time: ");
    for (int k1 = 0; k1 < Waiting_Time.length; k1++) {
      Waiting_Time[k1] = CpuTime - Arrival_Time[k1];
      System.out.println();
      System.out.println(CpuTime + "..." + Process_ID[k1]);
      CpuTime = CpuTime + Burst_Time[k1];
      // System.out.print(Waiting_Time[k1] + " ");
    }

    System.out.println();
    System.out.print("Turnaround_Time: ");
    for (int k2 = 0; k2 < Turnaround_Time.length; k2++) {
      Turnaround_Time[k2] = Waiting_Time[k2] + Burst_Time[k2];
      // System.out.print(Turnaround_Time[k2] + " ");
    }

    for (int j = 0; j <= CpuTime; j++) {
      System.out.println("Cpu Time = " + j);

      if (j >= 14 && j <= 18) {
        System.out.println("idle");
      } else {
        for (int k = 0; k < 5; k++) {
          if (Arrival_Time[k] == j)
            Process_State[k] = "new";
          if (Arrival_Time[k] < j)
            Process_State[k] = "ready";
          if (Arrival_Time[k] + Waiting_Time[k] <= j)
            Process_State[k] = "running";
          if (Turnaround_Time[k] <= j)
            Process_State[k] = "end";
        }
      }

      for (int k1 = 0; k1 < 5; k1++) {
        System.out.println("State " + Process_ID[k1] + " = " + Process_State[k1]);
      }
      System.out.println("----------------------------------");
    }

    System.out.println();
    System.out.println(" processID   arrivalTime   burstTime   waitingTime   turnaroundTime");

    for (int j = 0; j < 5; j++) {
      System.out
          .println("\t" + Process_ID[j] + "\t\t\t\t" + Arrival_Time[j] + "\t\t\t" + Burst_Time[j] + "\t\t\t"
              + Waiting_Time[j] + "\t\t\t" + Turnaround_Time[j]);
    }

    System.out.println();
    System.out.println("Process chart:");
    for (int j = 0; j < 5; j++) {
      System.out.println(Arrival_Time[j] + "..." + Process_ID[j] + "..." + Burst_Time[j]);
    }
  }
}
